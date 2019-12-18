package com.consignadoItau.controller;

import com.consignadoItau.controller.dto.ClienteAutorizadoConsignadoDto;
import com.consignadoItau.controller.dto.ClienteConsignadoContratoDto;
import com.consignadoItau.controller.form.ClienteConsignadoContratoForm;
import com.consignadoItau.dao.ClienteAutorizadoRepository;
import com.consignadoItau.dao.ClienteContratoRepository;
import com.consignadoItau.model.ClienteAutorizadoConsignado;
import com.consignadoItau.model.ClienteConsignadoContrato;
import com.consignadoItau.model.logic.ClienteAutorizadoConsignadoLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/clienteConsignado")
public class ClienteConsignadoController {

    @Autowired
    private ClienteAutorizadoRepository clienteAutorizadoRepository;

    @Autowired
    private ClienteContratoRepository clienteContratoRepository;

    private ClienteAutorizadoConsignadoLogic clienteAutorizadoConsignadoLogic = new ClienteAutorizadoConsignadoLogic();

    public ClienteConsignadoController() {
    }

    @GetMapping
    public List<ClienteAutorizadoConsignadoDto> listaClienteAutorizados(String cpfCliente){
        if(cpfCliente == null){
            List<ClienteAutorizadoConsignado> clientes = clienteAutorizadoRepository.findByFlagAutorizacaoCliente(true);
            return ClienteAutorizadoConsignadoDto.converter(clientes);
        }
        else{
            List<ClienteAutorizadoConsignado> cliente = clienteAutorizadoRepository.findByCpfCliente(cpfCliente);
            if(clienteAutorizadoConsignadoLogic
                    .clienteAutorizadoConsignado(clienteAutorizadoRepository,cpfCliente)){
                return ClienteAutorizadoConsignadoDto.converter(cliente);
            }
            else{
                return null;
            }
        }
    }

    @PostMapping
    public ResponseEntity<ClienteConsignadoContratoDto> contrataConsignado(@RequestBody ClienteConsignadoContratoForm clienteContratoForm, UriComponentsBuilder uriBuilder){
        if(clienteAutorizadoConsignadoLogic
                .clienteAutorizadoConsignado(clienteAutorizadoRepository, clienteContratoForm.getCpfCliente())){

            ClienteConsignadoContrato clienteContrato = clienteContratoForm.converter(clienteContratoForm, clienteAutorizadoRepository);
            clienteContratoRepository.save(clienteContrato);

            URI uri = uriBuilder.path("/clienteConsignado/{cpfCliente}").buildAndExpand(clienteContrato.getCpfCliente()).toUri();

            return ResponseEntity.created(uri).body(new ClienteConsignadoContratoDto(clienteContrato));

        }
        else{
            return new ResponseEntity("Cliente não autorizado", HttpStatus.OK);
        }
    }

    @PutMapping("/{cpfCliente}")
    @Transactional
    public ResponseEntity atualizaAutorizacaoCliente(@PathVariable String cpfCliente){
        if(clienteAutorizadoConsignadoLogic
                .autorizaAtulizacaoCadastroCliente(clienteAutorizadoRepository,cpfCliente)){
            List<ClienteAutorizadoConsignado> clienteAutorizado = clienteAutorizadoRepository.findByCpfCliente(cpfCliente);
            int idCliente = clienteAutorizado.stream().mapToInt(x -> x.getId()).sum();
            clienteAutorizadoConsignadoLogic.atualizaCadastroClienteAutorizado(clienteAutorizadoRepository, idCliente);

            return new ResponseEntity("Cliente autorizado", HttpStatus.OK);
        }
        else return new ResponseEntity("Cliente não atende as regras de autorização", HttpStatus.OK);
    }
}

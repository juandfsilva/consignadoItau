package com.consignadoItau.model.logic;

import com.consignadoItau.dao.ClienteAutorizadoRepository;
import com.consignadoItau.model.ClienteAutorizadoConsignado;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;


public class ClienteAutorizadoConsignadoLogic{

    public boolean clienteAutorizadoConsignado(ClienteAutorizadoRepository clienteRepository, String cpfCliente){
        List<ClienteAutorizadoConsignado> cliente = clienteRepository.findByCpfCliente(cpfCliente);
        if(cliente.stream()
                .allMatch(x -> x.isFlagAutorizacaoCliente() && x.getMargemBeneficioContratacao() > 0)){
            return true;
        }
        else return false;
    }

    public boolean autorizaAtulizacaoCadastroCliente(ClienteAutorizadoRepository clienteRepository, String cpfCliente){
        List<ClienteAutorizadoConsignado> cliente = clienteRepository.findByCpfCliente(cpfCliente);
        if(cliente == null){
            return false;
        }else{
            LocalDateTime dataDespacho = null;
            for(ClienteAutorizadoConsignado c : cliente){
                dataDespacho = c.getDataDespachoBeneficio();
            }
            if(Duration.between(dataDespacho, LocalDateTime.now()).toDays() >= 90){
                return true;
            }
            else return false;
        }
    }

    @Transactional
    public void atualizaCadastroClienteAutorizado(ClienteAutorizadoRepository clienteRepository, int idCliente) {
        ClienteAutorizadoConsignado clienteAtualizado = clienteRepository.getOne(idCliente);
        clienteAtualizado.setDataAutorizacaoConsulta(LocalDateTime.now());
        clienteAtualizado.setFlagAutorizacaoCliente(true);
    }
}

package com.consignadoItau.schedule;

import com.consignadoItau.dao.ClienteAutorizadoRepository;
import com.consignadoItau.model.ClienteAutorizadoConsignado;
import com.consignadoItau.model.logic.ClienteAutorizadoConsignadoLogic;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EnableScheduling
@Component
@Transactional
public class VerificadorClienteAutorizado {

    private static final String TIME_ZONE = "America/Sao_Paulo";

    @Autowired
    private ClienteAutorizadoRepository clienteAutorizadoRepository;

    private ClienteAutorizadoConsignadoLogic clienteAutorizadoConsignadoLogic = new ClienteAutorizadoConsignadoLogic();

    @Scheduled(cron = "0 0/1 * * * *", zone = TIME_ZONE)
    public void atualizaBaseClienteAutorizados()
    {
        List<ClienteAutorizadoConsignado> clientes = clienteAutorizadoRepository.findByFlagAutorizacaoCliente(false);

        for(ClienteAutorizadoConsignado cliente : clientes){
            if(Duration.between(cliente.getDataDespachoBeneficio(), LocalDateTime.now()).toDays() >= 90){
                clienteAutorizadoConsignadoLogic.atualizaCadastroClienteAutorizado(clienteAutorizadoRepository ,cliente.getId());
            }
            System.out.println(cliente.getCpfCliente());
        }
    }
}

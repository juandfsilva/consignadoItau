package com.consignadoItau.dao;

import com.consignadoItau.model.ClienteAutorizadoConsignado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteAutorizadoRepository extends JpaRepository<ClienteAutorizadoConsignado, Integer> {
    List<ClienteAutorizadoConsignado> findByCpfCliente(String cpfCliente);

    List<ClienteAutorizadoConsignado> findByFlagAutorizacaoCliente(boolean autorizacaoCliente);
}

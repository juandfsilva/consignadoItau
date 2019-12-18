package com.consignadoItau.dao;

import com.consignadoItau.model.ClienteConsignadoContrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteContratoRepository extends JpaRepository<ClienteConsignadoContrato, Integer> {
}

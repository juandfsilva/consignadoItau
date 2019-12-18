package com.consignadoItau;

import com.consignadoItau.dao.ClienteAutorizadoRepository;
import com.consignadoItau.dao.ClienteContratoRepository;
import com.consignadoItau.model.ClienteConsignadoContrato;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ConsignadoItauApplicationTests {

	final String urlBase = "http://localhost:8080/clienteConsignado";

	private RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private ClienteAutorizadoRepository clienteAutorizadoRepository;

	@Autowired
	private ClienteContratoRepository clienteContratoRepository;

	@Test
	public void testeContrataConsignado(){
		ClienteConsignadoContrato cliente =
				new ClienteConsignadoContrato("34567965456",10,15,LocalDateTime.of(2019,12,18,14,0), LocalDateTime.of(2020,12,18,14,0),212121233 );

		ClienteConsignadoContrato response = restTemplate.postForObject(urlBase, cliente, ClienteConsignadoContrato.class);

		Assert.assertEquals("34567965456", response.getCpfCliente());
	}

}

package com.consignadoItau.controller.form;

import com.consignadoItau.dao.ClienteAutorizadoRepository;
import com.consignadoItau.model.ClienteConsignadoContrato;
import org.aspectj.bridge.IMessage;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ClienteConsignadoContratoForm {

    @NotNull(message = "CPF do cliente é obrigatorio") @NotEmpty(message = "CPF do cliente não poder vazio")
    private String cpfCliente;

    @NotNull(message = "Quantidade de parcelas é obrigatoria")
    private int quantidadeParcelas;

    @NotNull(message = "Data de vencimento da parcela é obrigatorio")
    private int vencimentoParcela;

    @NotNull(message = "Data do inicio do contrato é obrigatorio")
    private LocalDateTime dataInicioContrato;

    @NotNull(message = "Data do encerramento do contrato é obrigatorio")
    private LocalDateTime dataEncerramentoContrato;

    @NotNull(message = "Numeor do beneficio do cliente é obrigatorio")
    private long numeroBeneficio;

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public int getVencimentoParcela() {
        return vencimentoParcela;
    }

    public void setVencimentoParcela(int vencimentoParcela) {
        this.vencimentoParcela = vencimentoParcela;
    }

    public LocalDateTime getDataInicioContrato() {
        return dataInicioContrato;
    }

    public void setDataInicioContrato(LocalDateTime dataInicioContrato) {
        this.dataInicioContrato = dataInicioContrato;
    }

    public LocalDateTime getDataEncerramentoContrato() {
        return dataEncerramentoContrato;
    }

    public void setDataEncerramentoContrato(LocalDateTime dataEncerramentoContrato) {
        this.dataEncerramentoContrato = dataEncerramentoContrato;
    }

    public long getNumeroBeneficio() {
        return numeroBeneficio;
    }

    public void setNumeroBeneficio(long numeroBeneficio) {
        this.numeroBeneficio = numeroBeneficio;
    }

    public ClienteConsignadoContrato converter(ClienteConsignadoContratoForm clienteContratoForm, ClienteAutorizadoRepository clienteAutorizadoRepository) {
        return  new ClienteConsignadoContrato(clienteContratoForm);
    }
}

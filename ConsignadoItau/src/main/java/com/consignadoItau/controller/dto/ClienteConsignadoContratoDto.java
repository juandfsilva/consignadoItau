package com.consignadoItau.controller.dto;

import com.consignadoItau.model.ClienteConsignadoContrato;

import java.time.LocalDateTime;

public class ClienteConsignadoContratoDto {

    private String cpfCliente;
    private int quantidadeParcelas;
    private int vencimentoParcela;
    private LocalDateTime dataInicioContrato;
    private LocalDateTime dataEncerramentoContrato;
    private long numeroBeneficio;

    public ClienteConsignadoContratoDto(ClienteConsignadoContrato clienteContrato) {
        this.cpfCliente = clienteContrato.getCpfCliente();
        this.quantidadeParcelas = clienteContrato.getQuantidadeParcelas();
        this.vencimentoParcela = clienteContrato.getVencimentoParcela();
        this.dataInicioContrato = clienteContrato.getDataInicioContrato();
        this.dataEncerramentoContrato = clienteContrato.getDataEncerramentoContrato();
        this.numeroBeneficio = clienteContrato.getNumeroBeneficio();
    }

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
}

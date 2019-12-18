package com.consignadoItau.controller.dto;

import com.consignadoItau.model.ClienteAutorizadoConsignado;
import com.consignadoItau.model.ClienteConsignadoContrato;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteAutorizadoConsignadoDto
{
    private String cpfCliente;
    private String nomeCliente;
    private LocalDateTime dataNascimentoCliente;
    private int margemBeneficioContratacao;
    private long numeroBeneficio;
    private LocalDateTime dataAutorizacaoConsulta;
    private LocalDateTime dataDespachoBeneficio;

    public ClienteAutorizadoConsignadoDto(ClienteAutorizadoConsignado clienteAutorizadoConsignado) {
        this.cpfCliente = clienteAutorizadoConsignado.getCpfCliente();
        this.nomeCliente = clienteAutorizadoConsignado.getNomeCliente();
        this.dataNascimentoCliente = clienteAutorizadoConsignado.getDataNascimentoCliente();
        this.margemBeneficioContratacao = clienteAutorizadoConsignado.getMargemBeneficioContratacao();
        this.numeroBeneficio = clienteAutorizadoConsignado.getNumeroBeneficio();
        this.dataAutorizacaoConsulta = clienteAutorizadoConsignado.getDataAutorizacaoConsulta();
        this.dataDespachoBeneficio = clienteAutorizadoConsignado.getDataDespachoBeneficio();
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public LocalDateTime getDataNascimentoCliente() {
        return dataNascimentoCliente;
    }

    public void setDataNascimentoCliente(LocalDateTime dataNascimentoCliente) {
        this.dataNascimentoCliente = dataNascimentoCliente;
    }

    public int getMargemBeneficioContratacao() {
        return margemBeneficioContratacao;
    }

    public void setMargemBeneficioContratacao(int margemBeneficioContratacao) {
        this.margemBeneficioContratacao = margemBeneficioContratacao;
    }

    public long getNumeroBeneficio() {
        return numeroBeneficio;
    }

    public void setNumeroBeneficio(long numeroBeneficio) {
        this.numeroBeneficio = numeroBeneficio;
    }

    public LocalDateTime getDataAutorizacaoConsulta() {
        return dataAutorizacaoConsulta;
    }

    public void setDataAutorizacaoConsulta(LocalDateTime dataAutorizacaoConsulta) {
        this.dataAutorizacaoConsulta = dataAutorizacaoConsulta;
    }

    public LocalDateTime getDataDespachoBeneficio() {
        return dataDespachoBeneficio;
    }

    public void setDataDespachoBeneficio(LocalDateTime dataDespachoBeneficio) {
        this.dataDespachoBeneficio = dataDespachoBeneficio;
    }

    public static List<ClienteAutorizadoConsignadoDto> converter(List<ClienteAutorizadoConsignado> clientes) {
        return clientes.stream().map(ClienteAutorizadoConsignadoDto::new).collect(Collectors.toList());
    }
}

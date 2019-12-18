package com.consignadoItau.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "CLIENTE_AUTORIZADO_CONSIGNADO")
public class ClienteAutorizadoConsignado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="CPF_CLIENTE")
    private String cpfCliente;

    @Column(name="NOME_CLIENTE")
    private String nomeCliente;

    @Column(name="DATA_NASCIMENTO_CLIENTE")
    private LocalDateTime dataNascimentoCliente;

    @Column(name="MARGEM_BENEFICIO_CONTRATACAO")
    private int margemBeneficioContratacao;

    @Column(name="NUMERO_BENEFICIO")
    private long numeroBeneficio;

    @Column(name="DATA_AUTORIZACAO_CONSULTA")
    private LocalDateTime dataAutorizacaoConsulta;

    @Column(name="DATA_DESPACHO_BENEFICIO")
    private LocalDateTime dataDespachoBeneficio;

    @Column(name="FLAG_AUTORIZACAO_CLIENTE")
    private boolean flagAutorizacaoCliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isFlagAutorizacaoCliente() {
        return flagAutorizacaoCliente;
    }

    public void setFlagAutorizacaoCliente(boolean flagAutorizacaoCliente) {
        this.flagAutorizacaoCliente = flagAutorizacaoCliente;
    }
}

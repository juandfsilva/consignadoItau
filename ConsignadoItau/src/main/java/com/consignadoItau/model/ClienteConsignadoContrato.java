package com.consignadoItau.model;

import com.consignadoItau.controller.form.ClienteConsignadoContratoForm;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "CLIENTE_CONSIGNADO_CONTRATO")
public class ClienteConsignadoContrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="CPF_CLIENTE")
    private String cpfCliente;

    @Column(name="QUANTIDADE_PARCELAS")
    private int quantidadeParcelas;

    @Column(name="VENCIMENTO_PARCELA")
    private int vencimentoParcela;

    @Column(name="DATA_INICIO_CONTRATO")
    private LocalDateTime dataInicioContrato;

    @Column(name="DATA_ENCERRAMENTO_CONTRATO")
    private LocalDateTime dataEncerramentoContrato;

    @Column(name="NUMERO_BENEFICIO")
    private long numeroBeneficio;

    public ClienteConsignadoContrato(String cpfCliente, int quantidadeParcelas, int vencimentoParcela, LocalDateTime dataInicioContrato, LocalDateTime dataEncerramentoContrato, long numeroBeneficio) {

        this.cpfCliente = cpfCliente;
        this.quantidadeParcelas = quantidadeParcelas;
        this.vencimentoParcela = vencimentoParcela;
        this.dataInicioContrato = dataInicioContrato;
        this.dataEncerramentoContrato = dataEncerramentoContrato;
        this.numeroBeneficio = numeroBeneficio;
    }

    public ClienteConsignadoContrato(ClienteConsignadoContratoForm clienteContratoForm) {
        this.cpfCliente = clienteContratoForm.getCpfCliente();
        this.quantidadeParcelas = clienteContratoForm.getQuantidadeParcelas();
        this.vencimentoParcela = clienteContratoForm.getVencimentoParcela();
        this.dataInicioContrato = clienteContratoForm.getDataInicioContrato();
        this.dataInicioContrato = clienteContratoForm.getDataInicioContrato();
        this.dataEncerramentoContrato = clienteContratoForm.getDataEncerramentoContrato();
        this.numeroBeneficio = clienteContratoForm.getNumeroBeneficio();
    }


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

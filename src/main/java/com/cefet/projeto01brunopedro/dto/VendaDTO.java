package com.cefet.projeto01brunopedro.dto;

import com.cefet.projeto01brunopedro.entities.Venda;

import java.math.BigDecimal;
import java.time.LocalDate;

public class VendaDTO {

    private Long id;
    private LocalDate data;
    private BigDecimal valor;
    private String observacao;
    private Long idPessoaCliente;
    private Long idPessoaFuncionario;

    public VendaDTO() {
    }

    public VendaDTO(Venda venda) {
        this.id = venda.getId();
        this.data = venda.getData();
        this.valor = venda.getValor();
        this.observacao = venda.getObservacao();
        this.idPessoaCliente = venda.getCliente().getId();
        this.idPessoaFuncionario = venda.getFuncionario().getId();
    }

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public Long getIdPessoaCliente() {
        return idPessoaCliente;
    }

    public Long getIdPessoaFuncionario() {
        return idPessoaFuncionario;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setIdPessoaCliente(Long idPessoaCliente) {
        this.idPessoaCliente = idPessoaCliente;
    }

    public void setIdPessoaFuncionario(Long idPessoaFuncionario) {
        this.idPessoaFuncionario = idPessoaFuncionario;
    }
}

package com.cefet.projeto01brunopedro.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    @Column(nullable = false)
    private BigDecimal valor;

    private String observacao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_pessoa_cliente")
    private Pessoa cliente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_pessoa_funcionario")
    private Pessoa funcionario;

    public Venda() {
    }

    public Venda(Long id, LocalDate data, BigDecimal valor, String observacao, Pessoa cliente, Pessoa funcionario) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.observacao = observacao;
        this.cliente = cliente;
        this.funcionario = funcionario;
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

    public Pessoa getCliente() {
        return cliente;
    }

    public Pessoa getFuncionario() {
        return funcionario;
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

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public void setFuncionario(Pessoa funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Venda)) return false;
        Venda venda = (Venda) o;
        return Objects.equals(id, venda.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

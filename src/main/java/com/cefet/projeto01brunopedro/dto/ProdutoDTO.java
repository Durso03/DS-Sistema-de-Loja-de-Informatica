package com.cefet.projeto01brunopedro.dto;

import com.cefet.projeto01brunopedro.entities.Produto;

import java.math.BigDecimal;

public class ProdutoDTO {

    private Long id;
    private String descricao;
    private BigDecimal valor;
    private Integer estoque;
    private Long idCategoria;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.descricao = produto.getDescricao();
        this.valor = produto.getValor();
        this.estoque = produto.getEstoque();
        this.idCategoria = produto.getCategoria().getId();
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }
}

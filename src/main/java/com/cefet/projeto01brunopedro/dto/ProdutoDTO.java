package com.cefet.projeto01brunopedro.dto;

import com.cefet.projeto01brunopedro.entities.Produto;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

@Schema(name = "ProdutoDTO", description = "DTO para representação de produtos")
public class ProdutoDTO {

    @Schema(description = "ID único do produto", example = "1")
    private Long id;

    @Schema(description = "Descrição/nome do produto", example = "Smartphone XYZ")
    private String descricao;

    @Schema(description = "Valor unitário do produto", example = "1999.99")
    private BigDecimal valor;

    @Schema(description = "Quantidade em estoque", example = "50")
    private Integer estoque;

    @Schema(description = "ID da categoria associada", example = "3")
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

    // Getters and Setters
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
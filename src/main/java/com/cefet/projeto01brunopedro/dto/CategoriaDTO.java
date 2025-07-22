package com.cefet.projeto01brunopedro.dto;

import com.cefet.projeto01brunopedro.entities.Categoria;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "CategoriaDTO", description = "DTO para representação de categorias")
public class CategoriaDTO {

    @Schema(description = "ID único da categoria", example = "1")
    private Long id;

    @Schema(description = "Descrição/nome da categoria", example = "Eletrônicos")
    private String descricao;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.descricao = categoria.getDescricao();
    }

    // Getters and Setters (mantidos iguais)
    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
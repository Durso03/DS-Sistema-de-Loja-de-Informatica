package com.cefet.projeto01brunopedro.dto;

import com.cefet.projeto01brunopedro.entities.Categoria;

public class CategoriaDTO {

    private Long id;
    private String descricao;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.descricao = categoria.getDescricao();
    }

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

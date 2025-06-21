package com.cefet.projeto01brunopedro.dto;

import com.cefet.projeto01brunopedro.entities.VendaProduto;

public class VendaProdutoDTO {

    private Long id;
    private Long idVenda;
    private Long idProduto;
    private Integer quantidade;

    public VendaProdutoDTO() {
    }

    public VendaProdutoDTO(VendaProduto vp) {
        this.id = vp.getId();
        this.idVenda = vp.getVenda().getId();
        this.idProduto = vp.getProduto().getId();
        this.quantidade = vp.getQuantidade();
    }

    public Long getId() {
        return id;
    }

    public Long getIdVenda() {
        return idVenda;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}

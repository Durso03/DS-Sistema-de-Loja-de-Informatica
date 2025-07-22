package com.cefet.projeto01brunopedro.dto;

import com.cefet.projeto01brunopedro.entities.VendaProduto;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "VendaProdutoDTO", description = "DTO para itens de venda (relação entre produtos e vendas)")
public class VendaProdutoDTO {

    @Schema(description = "ID único do item de venda", example = "1")
    private Long id;

    @Schema(description = "ID da venda associada", example = "100")
    private Long idVenda;

    @Schema(description = "ID do produto vendido", example = "25")
    private Long idProduto;

    @Schema(description = "Quantidade do produto vendido", example = "3", minimum = "1")
    private Integer quantidade;

    public VendaProdutoDTO() {
    }

    public VendaProdutoDTO(VendaProduto vp) {
        this.id = vp.getId();
        this.idVenda = vp.getVenda().getId();
        this.idProduto = vp.getProduto().getId();
        this.quantidade = vp.getQuantidade();
    }

    // Getters and Setters
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
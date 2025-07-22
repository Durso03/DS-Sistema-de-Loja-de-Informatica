package com.cefet.projeto01brunopedro.dto;

import com.cefet.projeto01brunopedro.entities.Venda;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(name = "VendaDTO", description = "DTO para representação de transações de venda")
public class VendaDTO {

    @Schema(description = "ID único da venda", example = "1")
    private Long id;

    @Schema(description = "Data da transação", example = "2023-05-15")
    private LocalDate data;

    @Schema(description = "Valor total da venda", example = "1599.99")
    private BigDecimal valor;

    @Schema(description = "Observações adicionais", example = "Embalar para presente")
    private String observacao;

    @Schema(description = "ID do cliente associado", example = "10")
    private Long idPessoaCliente;

    @Schema(description = "ID do funcionário responsável", example = "5")
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

    // Getters and Setters
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
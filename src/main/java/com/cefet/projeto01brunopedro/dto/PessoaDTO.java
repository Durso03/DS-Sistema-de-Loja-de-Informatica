package com.cefet.projeto01brunopedro.dto;

import com.cefet.projeto01brunopedro.entities.Pessoa;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "PessoaDTO", description = "DTO para representação de pessoas")
public class PessoaDTO {

    @Schema(description = "ID único da pessoa", example = "1")
    private Long id;

    @Schema(description = "Nome completo", example = "João da Silva")
    private String nome;

    @Schema(description = "CPF (somente números)", example = "12345678901")
    private String cpf;

    @Schema(description = "Endereço completo", example = "Rua ABC, 123 - Centro")
    private String endereco;

    @Schema(description = "Telefone para contato", example = "31987654321")
    private String telefone;

    @Schema(description = "E-mail válido", example = "joao@email.com")
    private String email;

    public PessoaDTO() {
    }

    public PessoaDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.cpf = pessoa.getCpf();
        this.endereco = pessoa.getEndereco();
        this.telefone = pessoa.getTelefone();
        this.email = pessoa.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
}
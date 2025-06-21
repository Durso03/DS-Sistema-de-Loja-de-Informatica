package com.cefet.projeto01brunopedro.dto;

import com.cefet.projeto01brunopedro.entities.Pessoa;

public class PessoaDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
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


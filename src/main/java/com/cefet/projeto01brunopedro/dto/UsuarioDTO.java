package com.cefet.projeto01brunopedro.dto;

import com.cefet.projeto01brunopedro.entities.Usuario;

public class UsuarioDTO {

    private Long id;
    private String login;
    private String senha;
    private String tipo;
    private Long idPessoa;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
        this.tipo = usuario.getTipo();
        this.idPessoa = usuario.getPessoa().getId();
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getTipo() {
        return tipo;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }
}

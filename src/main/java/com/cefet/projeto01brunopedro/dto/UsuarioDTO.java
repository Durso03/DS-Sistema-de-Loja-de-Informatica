package com.cefet.projeto01brunopedro.dto;

import com.cefet.projeto01brunopedro.entities.Usuario;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "UsuarioDTO", description = "DTO para representação de usuários do sistema")
public class UsuarioDTO {

    @Schema(description = "ID único do usuário", example = "1")
    private Long id;

    @Schema(description = "Nome de usuário para login", example = "usuario123")
    private String login;

    @Schema(description = "Senha de acesso (criptografada)", example = "******")
    private String senha;

    @Schema(description = "Tipo de perfil do usuário", example = "ADMIN", allowableValues = {"ADMIN", "USER"})
    private String tipo;

    @Schema(description = "ID da pessoa associada ao usuário", example = "5")
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

    // Getters and Setters
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
package com.cefet.projeto01brunopedro.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cefet.projeto01brunopedro.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
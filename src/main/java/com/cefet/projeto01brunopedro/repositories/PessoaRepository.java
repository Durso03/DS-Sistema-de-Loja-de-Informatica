package com.cefet.projeto01brunopedro.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cefet.projeto01brunopedro.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Optional<Pessoa> findByCpf(String cpf);
}

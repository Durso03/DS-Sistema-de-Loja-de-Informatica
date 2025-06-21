package com.cefet.projeto01brunopedro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cefet.projeto01brunopedro.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}

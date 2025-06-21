package com.cefet.projeto01brunopedro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cefet.projeto01brunopedro.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

package com.cefet.projeto01brunopedro.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cefet.projeto01brunopedro.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByCategoriaId(Long idCategoria);
}

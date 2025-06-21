package com.cefet.projeto01brunopedro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cefet.projeto01brunopedro.entities.VendaProduto;

public interface VendaProdutoRepository extends JpaRepository<VendaProduto, Long> {
}

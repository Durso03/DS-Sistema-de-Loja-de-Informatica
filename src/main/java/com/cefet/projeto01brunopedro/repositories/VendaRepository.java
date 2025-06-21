package com.cefet.projeto01brunopedro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cefet.projeto01brunopedro.entities.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}

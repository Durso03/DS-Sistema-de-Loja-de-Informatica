package com.cefet.projeto01brunopedro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cefet.projeto01brunopedro.dto.VendaDTO;
import com.cefet.projeto01brunopedro.services.VendaService;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public ResponseEntity<List<VendaDTO>> findAll() {
        return ResponseEntity.ok(vendaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendaDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(vendaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<VendaDTO> create(@RequestBody VendaDTO dto) {
        VendaDTO nova = vendaService.insert(dto);
        return ResponseEntity.status(201).body(nova);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendaDTO> update(@PathVariable Long id, @RequestBody VendaDTO dto) {
        VendaDTO atualizada = vendaService.update(id, dto);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vendaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

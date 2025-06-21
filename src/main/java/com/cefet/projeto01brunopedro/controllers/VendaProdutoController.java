package com.cefet.projeto01brunopedro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cefet.projeto01brunopedro.dto.VendaProdutoDTO;
import com.cefet.projeto01brunopedro.services.VendaProdutoService;

@RestController
@RequestMapping("/venda-produtos")
public class VendaProdutoController {

    @Autowired
    private VendaProdutoService vendaProdutoService;

    @GetMapping
    public ResponseEntity<List<VendaProdutoDTO>> findAll() {
        return ResponseEntity.ok(vendaProdutoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendaProdutoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(vendaProdutoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<VendaProdutoDTO> create(@RequestBody VendaProdutoDTO dto) {
        VendaProdutoDTO novo = vendaProdutoService.insert(dto);
        return ResponseEntity.status(201).body(novo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VendaProdutoDTO> update(@PathVariable Long id, @RequestBody VendaProdutoDTO dto) {
        VendaProdutoDTO atualizado = vendaProdutoService.update(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vendaProdutoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

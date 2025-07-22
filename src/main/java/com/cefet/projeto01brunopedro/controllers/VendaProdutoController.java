package com.cefet.projeto01brunopedro.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cefet.projeto01brunopedro.dto.VendaProdutoDTO;
import com.cefet.projeto01brunopedro.services.VendaProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/venda-produtos")
@Tag(name = "Itens de Venda", description = "Operações com itens de venda")
public class VendaProdutoController {

    @Autowired
    private VendaProdutoService vendaProdutoService;

    @GetMapping
    @Operation(summary = "Listar itens de venda")
    public ResponseEntity<List<VendaProdutoDTO>> findAll() {
        return ResponseEntity.ok(vendaProdutoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar item por ID")
    public ResponseEntity<VendaProdutoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(vendaProdutoService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Adicionar item à venda")
    public ResponseEntity<VendaProdutoDTO> create(@RequestBody VendaProdutoDTO dto) {
        VendaProdutoDTO novo = vendaProdutoService.insert(dto);
        return ResponseEntity.status(201).body(novo);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar item de venda")
    public ResponseEntity<VendaProdutoDTO> update(@PathVariable Long id, @RequestBody VendaProdutoDTO dto) {
        VendaProdutoDTO atualizado = vendaProdutoService.update(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover item da venda")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vendaProdutoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
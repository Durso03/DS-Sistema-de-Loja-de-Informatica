package com.cefet.projeto01brunopedro.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cefet.projeto01brunopedro.dto.VendaDTO;
import com.cefet.projeto01brunopedro.services.VendaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/vendas")
@Tag(name = "Vendas", description = "Operações com vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    @Operation(summary = "Listar vendas")
    public ResponseEntity<List<VendaDTO>> findAll() {
        return ResponseEntity.ok(vendaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar venda por ID")
    public ResponseEntity<VendaDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(vendaService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Registrar nova venda")
    public ResponseEntity<VendaDTO> create(@RequestBody VendaDTO dto) {
        VendaDTO nova = vendaService.insert(dto);
        return ResponseEntity.status(201).body(nova);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar venda")
    public ResponseEntity<VendaDTO> update(@PathVariable Long id, @RequestBody VendaDTO dto) {
        VendaDTO atualizada = vendaService.update(id, dto);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Cancelar venda")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vendaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
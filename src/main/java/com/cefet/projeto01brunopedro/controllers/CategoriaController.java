package com.cefet.projeto01brunopedro.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cefet.projeto01brunopedro.dto.CategoriaDTO;
import com.cefet.projeto01brunopedro.services.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@CrossOrigin(origins = "https://quine-mccluskey-informatica.netlify.app")
@RestController
@RequestMapping("/categorias")
@Tag(name = "Categoria Controller", description = "Endpoints para gerenciamento de categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    @Operation(summary = "Listar categorias", 
               description = "Retorna todas as categorias cadastradas",
               responses = {
                   @ApiResponse(responseCode = "200", description = "Lista de categorias retornada com sucesso")
               })
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        return ResponseEntity.ok(categoriaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar categoria por ID", 
               description = "Retorna uma categoria específica pelo seu identificador",
               responses = {
                   @ApiResponse(responseCode = "200", description = "Categoria encontrada"),
                   @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
               })
    public ResponseEntity<CategoriaDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Criar nova categoria", 
               description = "Cadastra uma nova categoria no sistema",
               responses = {
                   @ApiResponse(responseCode = "201", description = "Categoria criada com sucesso",
                              content = @Content(schema = @Schema(implementation = CategoriaDTO.class)))
               })
    public ResponseEntity<CategoriaDTO> create(@RequestBody CategoriaDTO dto) {
        CategoriaDTO novaCategoria = categoriaService.insert(dto);
        return ResponseEntity.status(201).body(novaCategoria);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar categoria", 
               description = "Atualiza os dados de uma categoria existente",
               responses = {
                   @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso"),
                   @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
               })
    public ResponseEntity<CategoriaDTO> update(@PathVariable Long id, @RequestBody CategoriaDTO dto) {
        CategoriaDTO atualizada = categoriaService.update(id, dto);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir categoria", 
               description = "Remove uma categoria do sistema",
               responses = {
                   @ApiResponse(responseCode = "204", description = "Categoria removida com sucesso"),
                   @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
               })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
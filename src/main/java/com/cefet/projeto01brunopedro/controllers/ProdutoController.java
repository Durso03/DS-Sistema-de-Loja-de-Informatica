package com.cefet.projeto01brunopedro.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cefet.projeto01brunopedro.dto.ProdutoDTO;
import com.cefet.projeto01brunopedro.services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Parameter;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/produtos")
@Tag(name = "Produto Controller", description = "Endpoints para gerenciamento de produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    @Operation(summary = "Listar todos os produtos",
               description = "Retorna todos os produtos cadastrados no sistema",
               responses = {
                   @ApiResponse(responseCode = "200", description = "Lista de produtos retornada com sucesso")
               })
    public ResponseEntity<List<ProdutoDTO>> findAll() {
        return ResponseEntity.ok(produtoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar produto por ID",
               description = "Retorna um produto específico pelo seu ID",
               responses = {
                   @ApiResponse(responseCode = "200", description = "Produto encontrado"),
                   @ApiResponse(responseCode = "404", description = "Produto não encontrado")
               })
    public ResponseEntity<ProdutoDTO> findById(
            @Parameter(description = "ID do produto a ser buscado", required = true)
            @PathVariable Long id) {
        return ResponseEntity.ok(produtoService.findById(id));
    }

    @GetMapping("/categoria/{id}")
    @Operation(summary = "Buscar produtos por categoria",
               description = "Retorna todos os produtos associados a uma categoria específica",
               responses = {
                   @ApiResponse(responseCode = "200", description = "Lista de produtos da categoria retornada"),
                   @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
               })
    public ResponseEntity<List<ProdutoDTO>> findByCategoriaId(
            @Parameter(description = "ID da categoria para filtro", required = true)
            @PathVariable Long id) {
        return ResponseEntity.ok(produtoService.findByCategoriaId(id));
    }

    @PostMapping
    @Operation(summary = "Criar novo produto",
               description = "Cadastra um novo produto no sistema",
               responses = {
                   @ApiResponse(responseCode = "201", description = "Produto criado com sucesso",
                              content = @Content(schema = @Schema(implementation = ProdutoDTO.class)))
               })
    public ResponseEntity<ProdutoDTO> create(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "Dados do produto a ser criado",
                required = true,
                content = @Content(schema = @Schema(implementation = ProdutoDTO.class)))
            @RequestBody ProdutoDTO dto) {
        ProdutoDTO novo = produtoService.insert(dto);
        return ResponseEntity.status(201).body(novo);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar produto",
               description = "Atualiza os dados de um produto existente",
               responses = {
                   @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso"),
                   @ApiResponse(responseCode = "404", description = "Produto não encontrado")
               })
    public ResponseEntity<ProdutoDTO> update(
            @Parameter(description = "ID do produto a ser atualizado", required = true)
            @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "Novos dados do produto",
                required = true,
                content = @Content(schema = @Schema(implementation = ProdutoDTO.class)))
            @RequestBody ProdutoDTO dto) {
        ProdutoDTO atualizado = produtoService.update(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir produto",
               description = "Remove um produto do sistema",
               responses = {
                   @ApiResponse(responseCode = "204", description = "Produto removido com sucesso"),
                   @ApiResponse(responseCode = "404", description = "Produto não encontrado")
               })
    public ResponseEntity<Void> delete(
            @Parameter(description = "ID do produto a ser removido", required = true)
            @PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
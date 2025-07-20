package com.cefet.projeto01brunopedro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.projeto01brunopedro.dto.ProdutoDTO;
import com.cefet.projeto01brunopedro.entities.Categoria;
import com.cefet.projeto01brunopedro.entities.Produto;
import com.cefet.projeto01brunopedro.repositories.CategoriaRepository;
import com.cefet.projeto01brunopedro.repositories.ProdutoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<ProdutoDTO> findAll() {
        return produtoRepository.findAll().stream().map(ProdutoDTO::new).toList();
    }

    public ProdutoDTO findById(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com ID: " + id));
        return new ProdutoDTO(produto);
    }

    public List<ProdutoDTO> findByCategoriaId(Long idCategoria) {
        List<Produto> produtos = produtoRepository.findByCategoriaId(idCategoria);
        return produtos.stream().map(ProdutoDTO::new).toList();
    }

    public ProdutoDTO insert(ProdutoDTO dto) {
        Categoria categoria = categoriaRepository.findById(dto.getIdCategoria())
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada com ID: " + dto.getIdCategoria()));

        Produto produto = new Produto();
        produto.setDescricao(dto.getDescricao());
        produto.setValor(dto.getValor());
        produto.setEstoque(dto.getEstoque());
        produto.setCategoria(categoria);

        produto = produtoRepository.save(produto);
        return new ProdutoDTO(produto);
    }

    public ProdutoDTO update(Long id, ProdutoDTO dto) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com ID: " + id));

        Categoria categoria = categoriaRepository.findById(dto.getIdCategoria())
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada com ID: " + dto.getIdCategoria()));

        produto.setDescricao(dto.getDescricao());
        produto.setValor(dto.getValor());
        produto.setEstoque(dto.getEstoque());
        produto.setCategoria(categoria);

        produto = produtoRepository.save(produto);
        return new ProdutoDTO(produto);
    }

    public void delete(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new EntityNotFoundException("Produto não encontrado com ID: " + id);
        }
        produtoRepository.deleteById(id);
    }
}

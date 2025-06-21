package com.cefet.projeto01brunopedro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.projeto01brunopedro.dto.VendaProdutoDTO;
import com.cefet.projeto01brunopedro.entities.Produto;
import com.cefet.projeto01brunopedro.entities.Venda;
import com.cefet.projeto01brunopedro.entities.VendaProduto;
import com.cefet.projeto01brunopedro.repositories.ProdutoRepository;
import com.cefet.projeto01brunopedro.repositories.VendaProdutoRepository;
import com.cefet.projeto01brunopedro.repositories.VendaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class VendaProdutoService {

    @Autowired
    private VendaProdutoRepository vendaProdutoRepository;

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<VendaProdutoDTO> findAll() {
        return vendaProdutoRepository.findAll().stream().map(VendaProdutoDTO::new).toList();
    }

    public VendaProdutoDTO findById(Long id) {
        VendaProduto vp = vendaProdutoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Item não encontrado com ID: " + id));
        return new VendaProdutoDTO(vp);
    }

    public VendaProdutoDTO insert(VendaProdutoDTO dto) {
        Venda venda = vendaRepository.findById(dto.getIdVenda())
                .orElseThrow(() -> new EntityNotFoundException("Venda não encontrada com ID: " + dto.getIdVenda()));

        Produto produto = produtoRepository.findById(dto.getIdProduto())
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com ID: " + dto.getIdProduto()));

        VendaProduto vp = new VendaProduto();
        vp.setVenda(venda);
        vp.setProduto(produto);
        vp.setQuantidade(dto.getQuantidade());

        vp = vendaProdutoRepository.save(vp);
        return new VendaProdutoDTO(vp);
    }

    public VendaProdutoDTO update(Long id, VendaProdutoDTO dto) {
        VendaProduto vp = vendaProdutoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Item não encontrado com ID: " + id));

        Venda venda = vendaRepository.findById(dto.getIdVenda())
                .orElseThrow(() -> new EntityNotFoundException("Venda não encontrada com ID: " + dto.getIdVenda()));

        Produto produto = produtoRepository.findById(dto.getIdProduto())
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com ID: " + dto.getIdProduto()));

        vp.setVenda(venda);
        vp.setProduto(produto);
        vp.setQuantidade(dto.getQuantidade());

        vp = vendaProdutoRepository.save(vp);
        return new VendaProdutoDTO(vp);
    }

    public void delete(Long id) {
        if (!vendaProdutoRepository.existsById(id)) {
            throw new EntityNotFoundException("Item não encontrado com ID: " + id);
        }
        vendaProdutoRepository.deleteById(id);
    }
}

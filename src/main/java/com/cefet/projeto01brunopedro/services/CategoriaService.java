package com.cefet.projeto01brunopedro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.projeto01brunopedro.dto.CategoriaDTO;
import com.cefet.projeto01brunopedro.entities.Categoria;
import com.cefet.projeto01brunopedro.repositories.CategoriaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<CategoriaDTO> findAll() {
        return categoriaRepository.findAll().stream()
                .map(CategoriaDTO::new).toList();
    }

    public CategoriaDTO findById(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada com ID: " + id));
        return new CategoriaDTO(categoria);
    }

    public CategoriaDTO insert(CategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setDescricao(dto.getDescricao());
        categoria = categoriaRepository.save(categoria);
        return new CategoriaDTO(categoria);
    }

    public CategoriaDTO update(Long id, CategoriaDTO dto) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada com ID: " + id));
        categoria.setDescricao(dto.getDescricao());
        categoria = categoriaRepository.save(categoria);
        return new CategoriaDTO(categoria);
    }

    public void delete(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new EntityNotFoundException("Categoria não encontrada com ID: " + id);
        }
        categoriaRepository.deleteById(id);
    }
}

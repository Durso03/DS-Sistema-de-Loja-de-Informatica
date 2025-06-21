package com.cefet.projeto01brunopedro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.projeto01brunopedro.dto.PessoaDTO;
import com.cefet.projeto01brunopedro.entities.Pessoa;
import com.cefet.projeto01brunopedro.repositories.PessoaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaDTO> findAll() {
        List<Pessoa> listaPessoa = pessoaRepository.findAll();
        return listaPessoa.stream().map(PessoaDTO::new).toList();
    }

    public PessoaDTO findById(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com ID: " + id));
        return new PessoaDTO(pessoa);
    }

    public PessoaDTO insert(PessoaDTO dto) {
        Pessoa pessoa = new Pessoa();
        copiarDtoParaEntidade(dto, pessoa);
        pessoa = pessoaRepository.save(pessoa);
        return new PessoaDTO(pessoa);
    }

    public PessoaDTO update(Long id, PessoaDTO dto) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com ID: " + id));
        copiarDtoParaEntidade(dto, pessoa);
        pessoa = pessoaRepository.save(pessoa);
        return new PessoaDTO(pessoa);
    }

    public void delete(Long id) {
        if (!pessoaRepository.existsById(id)) {
            throw new EntityNotFoundException("Pessoa não encontrada com ID: " + id);
        }
        pessoaRepository.deleteById(id);
    }

    private void copiarDtoParaEntidade(PessoaDTO dto, Pessoa pessoa) {
        pessoa.setNome(dto.getNome());
        pessoa.setCpf(dto.getCpf());
        pessoa.setEndereco(dto.getEndereco());
        pessoa.setTelefone(dto.getTelefone());
        pessoa.setEmail(dto.getEmail());
    }
}

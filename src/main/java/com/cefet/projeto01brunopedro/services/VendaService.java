package com.cefet.projeto01brunopedro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.projeto01brunopedro.dto.VendaDTO;
import com.cefet.projeto01brunopedro.entities.Pessoa;
import com.cefet.projeto01brunopedro.entities.Venda;
import com.cefet.projeto01brunopedro.repositories.PessoaRepository;
import com.cefet.projeto01brunopedro.repositories.VendaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<VendaDTO> findAll() {
        return vendaRepository.findAll().stream().map(VendaDTO::new).toList();
    }

    public VendaDTO findById(Long id) {
        Venda venda = vendaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Venda não encontrada com ID: " + id));
        return new VendaDTO(venda);
    }

    public VendaDTO insert(VendaDTO dto) {
        Pessoa cliente = pessoaRepository.findById(dto.getIdPessoaCliente())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID: " + dto.getIdPessoaCliente()));

        Pessoa funcionario = pessoaRepository.findById(dto.getIdPessoaFuncionario())
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado com ID: " + dto.getIdPessoaFuncionario()));

        Venda venda = new Venda();
        venda.setData(dto.getData());
        venda.setValor(dto.getValor());
        venda.setObservacao(dto.getObservacao());
        venda.setCliente(cliente);
        venda.setFuncionario(funcionario);

        venda = vendaRepository.save(venda);
        return new VendaDTO(venda);
    }

    public VendaDTO update(Long id, VendaDTO dto) {
        Venda venda = vendaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Venda não encontrada com ID: " + id));

        Pessoa cliente = pessoaRepository.findById(dto.getIdPessoaCliente())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado com ID: " + dto.getIdPessoaCliente()));

        Pessoa funcionario = pessoaRepository.findById(dto.getIdPessoaFuncionario())
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado com ID: " + dto.getIdPessoaFuncionario()));

        venda.setData(dto.getData());
        venda.setValor(dto.getValor());
        venda.setObservacao(dto.getObservacao());
        venda.setCliente(cliente);
        venda.setFuncionario(funcionario);

        venda = vendaRepository.save(venda);
        return new VendaDTO(venda);
    }

    public void delete(Long id) {
        if (!vendaRepository.existsById(id)) {
            throw new EntityNotFoundException("Venda não encontrada com ID: " + id);
        }
        vendaRepository.deleteById(id);
    }
}

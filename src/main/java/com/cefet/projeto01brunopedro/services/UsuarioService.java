package com.cefet.projeto01brunopedro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.projeto01brunopedro.dto.UsuarioDTO;
import com.cefet.projeto01brunopedro.entities.Pessoa;
import com.cefet.projeto01brunopedro.entities.Usuario;
import com.cefet.projeto01brunopedro.repositories.PessoaRepository;
import com.cefet.projeto01brunopedro.repositories.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<UsuarioDTO> findAll() {
        List<Usuario> lista = usuarioRepository.findAll();
        return lista.stream().map(UsuarioDTO::new).toList();
    }

    public UsuarioDTO findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));
        return new UsuarioDTO(usuario);
    }

    public UsuarioDTO insert(UsuarioDTO dto) {
        Pessoa pessoa = pessoaRepository.findById(dto.getIdPessoa())
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com ID: " + dto.getIdPessoa()));

        Usuario usuario = new Usuario();
        usuario.setLogin(dto.getLogin());
        usuario.setSenha(dto.getSenha());
        usuario.setTipo(dto.getTipo());
        usuario.setPessoa(pessoa);

        usuario = usuarioRepository.save(usuario);
        return new UsuarioDTO(usuario);
    }

    public UsuarioDTO update(Long id, UsuarioDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));

        Pessoa pessoa = pessoaRepository.findById(dto.getIdPessoa())
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com ID: " + dto.getIdPessoa()));

        usuario.setLogin(dto.getLogin());
        usuario.setSenha(dto.getSenha());
        usuario.setTipo(dto.getTipo());
        usuario.setPessoa(pessoa);

        usuario = usuarioRepository.save(usuario);
        return new UsuarioDTO(usuario);
    }

    public void delete(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new EntityNotFoundException("Usuário não encontrado com ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }
}

package com.fiap.gsJava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.gsJava.model.Usuario;
import com.fiap.gsJava.model.dto.UsuarioDto;
import com.fiap.gsJava.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> getAll() {
        return repository.findAll();
    }

    public Usuario getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public Usuario create(UsuarioDto dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setTelefone(dto.getTelefone());
        usuario.setTelefoneEmergencia(dto.getTelefoneEmergencia());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        return repository.save(usuario);
    }

    public Usuario update(Long id, UsuarioDto dto) {
        Usuario usuario = getById(id);
        usuario.setNome(dto.getNome());
        usuario.setTelefone(dto.getTelefone());
        usuario.setTelefoneEmergencia(dto.getTelefoneEmergencia());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        return repository.save(usuario);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

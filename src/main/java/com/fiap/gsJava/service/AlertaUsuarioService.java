package com.fiap.gsJava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.gsJava.model.AlertaUsuario;
import com.fiap.gsJava.model.Evento;
import com.fiap.gsJava.model.Localizacao;
import com.fiap.gsJava.model.Usuario;
import com.fiap.gsJava.model.dto.AlertaUsuarioDto;
import com.fiap.gsJava.repository.AlertaUsuarioRepository;
import com.fiap.gsJava.repository.EventoRepository;
import com.fiap.gsJava.repository.LocalizacaoRepository;
import com.fiap.gsJava.repository.UsuarioRepository;

@Service
public class AlertaUsuarioService {

    @Autowired
    private AlertaUsuarioRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    @Autowired
    private EventoRepository eventoRepository;

    public List<AlertaUsuario> getAll() {
        return repository.findAll();
    }

    public AlertaUsuario getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Alerta não encontrado"));
    }

    public AlertaUsuario create(AlertaUsuarioDto dto) {
        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Localizacao localizacao = localizacaoRepository.findById(dto.getIdLocalizacao())
                .orElseThrow(() -> new RuntimeException("Localização não encontrada"));

        Evento evento = eventoRepository.findById(dto.getIdEvento())
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));

        AlertaUsuario alerta = new AlertaUsuario();
        alerta.setId(dto.getId());
        alerta.setDataAlerta(dto.getDataAlerta());
        alerta.setGravidade(dto.getGravidade());
        alerta.setUsuario(usuario);
        alerta.setLocalizacao(localizacao);
        alerta.setEvento(evento);

        return repository.save(alerta);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

package com.fiap.gsJava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.gsJava.model.AlertaUsuario;
import com.fiap.gsJava.model.MidiaAlerta;
import com.fiap.gsJava.model.dto.MidiaAlertaDto;
import com.fiap.gsJava.repository.AlertaUsuarioRepository;
import com.fiap.gsJava.repository.MidiaAlertaRepository;

@Service
public class MidiaAlertaService {

    @Autowired
    private MidiaAlertaRepository repository;

    @Autowired
    private AlertaUsuarioRepository alertaRepository;

    public List<MidiaAlerta> getAll() {
        return repository.findAll();
    }

    public MidiaAlerta getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Mídia não encontrada"));
    }

    public MidiaAlerta create(MidiaAlertaDto dto) {
        AlertaUsuario alerta = alertaRepository.findById(dto.getIdAlerta())
                .orElseThrow(() -> new RuntimeException("Alerta não encontrado"));

        MidiaAlerta midia = new MidiaAlerta();
        midia.setCaminho(dto.getCaminho());
        midia.setTipo(dto.getTipo());
        midia.setAlerta(alerta);

        return repository.save(midia);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
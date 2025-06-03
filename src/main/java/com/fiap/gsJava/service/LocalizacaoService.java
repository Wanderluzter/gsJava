package com.fiap.gsJava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.gsJava.model.Localizacao;
import com.fiap.gsJava.model.dto.LocalizacaoDto;
import com.fiap.gsJava.repository.LocalizacaoRepository;

@Service
public class LocalizacaoService {

    @Autowired
    private LocalizacaoRepository repository;

    public List<Localizacao> getAll() {
        return repository.findAll();
    }

    public Localizacao getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Localização não encontrada"));
    }

    public Localizacao create(LocalizacaoDto dto) {
        Localizacao loc = new Localizacao();
        loc.setCidade(dto.getCidade());
        loc.setEstado(dto.getEstado());
        loc.setLatitude(dto.getLatitude());
        loc.setLongitude(dto.getLongitude());
        return repository.save(loc);
    }

    public Localizacao update(Long id, LocalizacaoDto dto) {
        Localizacao loc = getById(id);
        loc.setCidade(dto.getCidade());
        loc.setEstado(dto.getEstado());
        loc.setLatitude(dto.getLatitude());
        loc.setLongitude(dto.getLongitude());
        return repository.save(loc);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

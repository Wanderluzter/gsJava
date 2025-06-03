package com.fiap.gsJava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.gsJava.model.Evento;
import com.fiap.gsJava.model.dto.EventoDto;
import com.fiap.gsJava.repository.EventoRepository;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;

    public List<Evento> getAll() {
        return repository.findAll();
    }

    public Evento getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Evento não encontrado"));
    }

    public Evento create(EventoDto dto) {
        Evento evento = new Evento();
        evento.setNomeEvento(dto.getNomeEvento());
        return repository.save(evento);
    }

    public Evento update(Long id, EventoDto dto) {
        Evento evento = getById(id);
        evento.setNomeEvento(dto.getNomeEvento());
        return repository.save(evento);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

package com.fiap.gsJava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.gsJava.model.Evento;
import com.fiap.gsJava.model.dto.EventoDto;
import com.fiap.gsJava.service.EventoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    @Autowired
    private EventoService service;

    @GetMapping
    public List<Evento> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Evento getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Evento create(@RequestBody @Valid EventoDto dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public Evento update(@PathVariable Long id, @RequestBody @Valid EventoDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

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

import com.fiap.gsJava.model.Localizacao;
import com.fiap.gsJava.model.dto.LocalizacaoDto;
import com.fiap.gsJava.service.LocalizacaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/localizacoes")
public class LocalizacaoController {

    @Autowired
    private LocalizacaoService service;

    @GetMapping
    public List<Localizacao> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Localizacao getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Localizacao create(@RequestBody @Valid LocalizacaoDto dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public Localizacao update(@PathVariable Long id, @RequestBody @Valid LocalizacaoDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

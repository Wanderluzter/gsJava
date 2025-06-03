package com.fiap.gsJava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.gsJava.model.Previsao;
import com.fiap.gsJava.model.dto.PrevisaoDto;
import com.fiap.gsJava.service.PrevisaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/previsoes")
public class PrevisaoController {

    @Autowired
    private PrevisaoService service;

    @GetMapping
    public List<Previsao> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Previsao getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Previsao create(@RequestBody @Valid PrevisaoDto dto) {
        return service.create(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

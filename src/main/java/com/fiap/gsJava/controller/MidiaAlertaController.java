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

import com.fiap.gsJava.model.MidiaAlerta;
import com.fiap.gsJava.model.dto.MidiaAlertaDto;
import com.fiap.gsJava.service.MidiaAlertaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/midias")
public class MidiaAlertaController {

    @Autowired
    private MidiaAlertaService service;

    @GetMapping
    public List<MidiaAlerta> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public MidiaAlerta getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public MidiaAlerta create(@RequestBody @Valid MidiaAlertaDto dto) {
        return service.create(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

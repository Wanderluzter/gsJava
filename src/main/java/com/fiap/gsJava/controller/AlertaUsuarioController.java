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

import com.fiap.gsJava.model.AlertaUsuario;
import com.fiap.gsJava.model.dto.AlertaUsuarioDto;
import com.fiap.gsJava.service.AlertaUsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/alertas")
public class AlertaUsuarioController {

    @Autowired
    private AlertaUsuarioService service;

    @GetMapping
    public List<AlertaUsuario> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public AlertaUsuario getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public AlertaUsuario create(@RequestBody @Valid AlertaUsuarioDto dto) {
        return service.create(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

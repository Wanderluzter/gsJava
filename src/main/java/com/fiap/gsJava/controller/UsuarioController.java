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

import com.fiap.gsJava.model.Usuario;
import com.fiap.gsJava.model.dto.UsuarioDto;
import com.fiap.gsJava.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> getAll() {
        return service.getAll();
    }
    
    @GetMapping("/{id}")
    public Usuario getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/email/{email}")
    public Usuario getByEmail(@PathVariable String email) {
        return service.getByEmail(email);
    }

    @PostMapping
    public Usuario create(@RequestBody @Valid UsuarioDto dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody @Valid UsuarioDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

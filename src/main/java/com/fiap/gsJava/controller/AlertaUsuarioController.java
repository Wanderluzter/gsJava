package com.fiap.gsJava.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.gsJava.model.AlertaUsuario;
import com.fiap.gsJava.model.dto.AlertaUsuarioDto;
import com.fiap.gsJava.repository.AlertaUsuarioRepository;
import com.fiap.gsJava.service.AlertaUsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/alertas")
public class AlertaUsuarioController {

    @Autowired
    private AlertaUsuarioService service;

    @Autowired
    private AlertaUsuarioRepository alertaUsuarioRepository;

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

    @DeleteMapping("/alerta/{id}")
    public ResponseEntity<?> deletarAlerta(@PathVariable Long id, @RequestParam Long idUsuario) {;
    Optional<AlertaUsuario> alertaOpt = alertaUsuarioRepository.findById(id);

    if (alertaOpt.isEmpty()) {
        return ResponseEntity.notFound().build();
    }

    AlertaUsuario alerta = alertaOpt.get();

    if (!alerta.getUsuario().getId().equals(idUsuario)) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body("Você não tem permissão para deletar este alerta.");
    }

    alertaUsuarioRepository.delete(alerta);
    return ResponseEntity.noContent().build();
}

}

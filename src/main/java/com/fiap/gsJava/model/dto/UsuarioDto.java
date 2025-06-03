package com.fiap.gsJava.model.dto;

import lombok.Data;

@Data
public class UsuarioDto {
    private Long id;
    private String nome;
    private String telefone;
    private String telefoneEmergencia;
    private String email;
    private String senha;
}

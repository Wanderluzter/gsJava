package com.fiap.gsJava.model.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class AlertaUsuarioDto {
    private Long id;
    private LocalDate dataAlerta;
    private String gravidade;
    private Long idUsuario;
    private Long idLocalizacao;
    private Long idEvento;
}

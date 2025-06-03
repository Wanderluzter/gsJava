package com.fiap.gsJava.model.dto;

import lombok.Data;

@Data
public class MidiaAlertaDto {
    private Long id;
    private String caminho;
    private String tipo;
    private Long idAlerta;
}

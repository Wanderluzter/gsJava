package com.fiap.gsJava.model.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PrevisaoDto {
    private Long id;
    private LocalDate dataPrevisao;
    private Integer temperaturaMax;
    private Integer temperaturaMin;
    private Integer umidade;
    private Integer velocidadeVento;
    private Integer indiceUv;
    private String qualidadeAr;
    private Long idLocalizacao;
}

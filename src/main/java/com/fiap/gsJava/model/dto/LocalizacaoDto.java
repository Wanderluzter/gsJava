package com.fiap.gsJava.model.dto;

import lombok.Data;

@Data
public class LocalizacaoDto {
    private Long id;
    private String cidade;
    private String estado;
    private Double latitude;
    private Double longitude;
}

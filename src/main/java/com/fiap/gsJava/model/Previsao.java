package com.fiap.gsJava.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "previsao")
@Data
public class Previsao {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id_previsao")
    private Long id;

    @NotNull
    @Column(name = "data_previsao")
    private LocalDate dataPrevisao;

    @NotNull
    @Column(name = "temperatura_max")
    private Integer temperaturaMax;

    @NotNull
    @Column(name = "temperatura_min")
    private Integer temperaturaMin;

    @NotNull
    private Integer umidade;

    @NotNull
    @Column(name = "velocidade_vento")
    private Integer velocidadeVento;

    @NotNull
    @Column(name = "indice_uv")
    private Integer indiceUv;

    @NotBlank(message = "Qualidade do ar é obrigatória")
    @Column(name = "qualidade_ar")
    private String qualidadeAr;

    @ManyToOne
    @JoinColumn(name = "id_localizacao", nullable = false)
    private Localizacao localizacao;

}

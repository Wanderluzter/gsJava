package com.fiap.gsJava.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "localizacao")
@Data
public class Localizacao {

    @Id
    @Column(name = "id_localizacao")
    private Long id;

    @NotBlank(message = "Cidade é obrigatória")
    private String cidade;

    @NotBlank(message = "Estado é obrigatório")
    private String estado;

    @NotNull(message = "Latitude obrigatória")
    private Double latitude;

    @NotNull(message = "Longitude obrigatória")
    private Double longitude;

}

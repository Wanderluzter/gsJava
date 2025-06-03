package com.fiap.gsJava.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "midia_alerta")
@Data
public class MidiaAlerta {

    @Id
    @Column(name = "id_midia")
    private Long id;

    @NotBlank(message = "Caminho da mídia é obrigatório")
    private String caminho;

    @NotBlank(message = "Tipo de mídia é obrigatório")
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "id_alerta", nullable = false)
    private AlertaUsuario alerta;

}

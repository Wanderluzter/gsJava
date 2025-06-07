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
@Table(name = "alerta_usuario")
@Data
public class AlertaUsuario {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id_alerta")
    private Long id;

    @Column(name = "data_alerta")
    private LocalDate dataAlerta;

    @NotBlank(message = "Descrição do alerta é obrigatória")
    private String descricao;

    @NotNull(message = "Localização é obrigatória")
    @ManyToOne
    @JoinColumn(name = "id_localizacao", nullable = false)
    private Localizacao localizacao;

    @NotNull(message = "Usuário é obrigatório")
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @NotNull(message = "Evento é obrigatório")
    @ManyToOne
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento evento;

}

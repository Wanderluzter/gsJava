package com.fiap.gsJava.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String dataHora;
    private String tipo;
    private String descricao;
    private String localizacao;
}

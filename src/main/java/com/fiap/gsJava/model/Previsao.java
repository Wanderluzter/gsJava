package com.fiap.gsJava.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Previsao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String data;
    private String temperaturaMinima;
    private String temperaturaMaxima;
    private String umidade;
    private String vento;
    private String visibilidade;
    private String pressaoAtmosferica;
    private String localizacao;

}

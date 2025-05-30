package com.fiap.gsJava.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Usuario {

    @Id
    private String cpf;
    @NotBlank(message = "Nome não pode ser vazio")
    @Size(min = 3, max = 50, message = "Nome deve ter entre 3 e 50 caracteres")
    private String nome;
    @NotBlank(message = "Telefone não pode ser vazio")
    @Size(min = 10, max = 15, message = "Telefone deve ter entre 10 e 15 caracteres")
    private String telefone;
    @NotBlank(message = "Telefone de emergência não pode ser vazio")
    @Size(min = 10, max = 15, message = "Telefone de emergência deve ter entre 10 e 15 caracteres")
    private String telefoneEmergencia;
    @NotBlank(message = "Email não pode ser vazio")
    @Size(max = 100, message = "Email deve ter no máximo 100 caracteres")
    private String email;
    @NotBlank(message = "Senha não pode ser vazia")
    @Size(min = 6, max = 20, message = "Senha deve ter entre 6 e 20 caracteres")
    private String senha;
}

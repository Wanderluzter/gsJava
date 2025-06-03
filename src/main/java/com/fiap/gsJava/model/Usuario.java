package com.fiap.gsJava.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {

    @Id
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 50)
    private String nome;

    @Pattern(regexp = "\\d{10,13}", message = "Telefone deve conter entre 10 e 13 dígitos")
    private String telefone;

    @Pattern(regexp = "\\d{10,13}", message = "Telefone de emergência deve conter entre 10 e 13 dígitos")
    private String telefoneEmergencia;

    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 6, max = 30, message = "Senha deve ter entre 6 e 30 caracteres")
    private String senha;

}

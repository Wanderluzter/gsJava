package com.fiap.gsJava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.fiap.gsJava.model.Usuario;
import com.fiap.gsJava.repository.UsuarioRepository;

@Component
public class PasswordEncryptorRunner implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        List<Usuario> usuarios = usuarioRepository.findAll();

        for (Usuario u : usuarios) {
            String senha = u.getSenha();
            if (senha != null && !senha.startsWith("$2a$") && !senha.startsWith("$2b$") && !senha.startsWith("$2y$")) {
                String encoded = passwordEncoder.encode(senha);
                u.setSenha(encoded);
                usuarioRepository.save(u);
                System.out.println("Senha do usuário " + u.getEmail() + " criptografada.");
            } else {
                System.out.println("Senha do usuário " + u.getEmail() + " já está criptografada, pulando.");
            }
        }

        System.out.println("Atualização de senhas finalizada!");
    }
}

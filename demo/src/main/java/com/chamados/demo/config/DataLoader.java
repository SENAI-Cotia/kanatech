package com.chamados.demo.config;

import com.chamados.demo.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.chamados.demo.model.Usuario;

@Component
public class DataLoader implements CommandLineRunner {

    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;

    public DataLoader(UsuarioRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) {
        if (repository.findByUsername("admin").isEmpty()) {
            Usuario usuario = new Usuario();
            usuario.setUsername("admin");
            usuario.setPassword(encoder.encode("123"));
            usuario.setRole("ADMIN");
            repository.save(usuario);
        }
    }
}
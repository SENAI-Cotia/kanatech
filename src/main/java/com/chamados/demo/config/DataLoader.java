package com.chamados.demo.config;

import com.chamados.demo.model.User;
import com.chamados.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public DataLoader(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) {

        if (repository.findByUsername("admin").isEmpty()) {

            User user = new User();
            user.setUsername("admin");
            user.setPassword(encoder.encode("123"));
            user.setRole("ADMIN");

            repository.save(user);
        }
    }
}
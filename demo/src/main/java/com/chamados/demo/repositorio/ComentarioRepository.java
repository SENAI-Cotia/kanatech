package com.chamados.demo.repositorio;

import com.chamados.demo.model.Comentario;
import jakarta.transaction.UserTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    }
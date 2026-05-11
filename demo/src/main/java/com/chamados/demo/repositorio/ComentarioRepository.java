package com.chamados.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

    public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    }
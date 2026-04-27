package com.chamados.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensagem;
    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "chamado_id")
    private Chamado chamado;


}
package com.chamados.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private String status;

    private LocalDateTime dataAbertura;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


}
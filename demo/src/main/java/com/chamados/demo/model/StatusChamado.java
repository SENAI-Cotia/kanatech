package com.chamados.demo.model;

public enum StatusChamado {

    ABERTO("Aberto"),
    EM_ANDAMENTO("Em Andamento"),
    AGUARDANDO("Aguardando"),
    RESOLVIDO("Resolvido"),
    FECHADO("Fechado");

    private final String descricao;

    StatusChamado(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
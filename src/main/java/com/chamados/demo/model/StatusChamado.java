package com.chamados.demo.model;

public enum StatusChamado {
    ABERTO("Aberto"),
    EM_ATENDIMENTO("Em Atendimento"),
    ENCERRADO("Encerrado");

    private final String descricao;

    StatusChamado(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
git
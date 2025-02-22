package com.businesscase.software_engineering.headerPaginator;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class HeaderPaginator<T> {

    @JsonProperty("limite")
    private int limite;

    @JsonProperty("paginaAtual")
    private int paginaAtual;

    @JsonProperty("totalRegistros")
    private int totalRegistros;

    @JsonProperty("totalPaginas")
    private int totalPaginas;

    @JsonProperty("registros")
    private List<T> registros;


    public HeaderPaginator(int limite, int paginaAtual, int totalRegistros, int totalPaginas, List<T> registros) {
        this.limite = limite;
        this.paginaAtual = paginaAtual;
        this.totalRegistros = totalRegistros;
        this.totalPaginas = totalPaginas;
        this.registros = registros;
    }
}

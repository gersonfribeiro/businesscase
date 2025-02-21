package com.businesscase.software_engineering.headerPaginator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class HeaderPaginator<T> {
    private int limite;
    private int paginaAtual;
    private int totalRegistros;
    private int totalPaginas;
    private List<T> registros;
}

package com.businesscase.software_engineering.application.tasks.exceptions;

import lombok.Getter;

@Getter
public class TaskNotFoundByParam extends RuntimeException {

    private final String parametro;

    public TaskNotFoundByParam(String parametro) {
        super(String.format("Task não encontrada para o parâmetro de busca: %s", parametro));
        this.parametro = parametro;
    }
}

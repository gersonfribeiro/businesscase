package com.businesscase.software_engineering.application.tasks.exceptions;

import lombok.Getter;

@Getter
public class TaskNotFound extends RuntimeException {

    private final int id_task;

    public TaskNotFound(int id_task) {
        super(String.format("Task não encontrada para o id: %s", id_task));
        this.id_task = id_task;
    }
}

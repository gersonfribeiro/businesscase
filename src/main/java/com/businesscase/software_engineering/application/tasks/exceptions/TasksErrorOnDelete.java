package com.businesscase.software_engineering.application.tasks.exceptions;

import lombok.Getter;

@Getter
public class TasksErrorOnDelete extends RuntimeException {
    private final int id_task;

    public TasksErrorOnDelete(int idTask) {
        super(String.format("Ocorreu um erro ao tentar remover a task para id: %s", idTask));
        id_task = idTask;
    }
}

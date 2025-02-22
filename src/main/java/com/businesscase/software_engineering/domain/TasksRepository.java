package com.businesscase.software_engineering.domain;

import com.businesscase.software_engineering.headerPaginator.HeaderPaginator;

import java.util.List;

public interface TasksRepository {

    HeaderPaginator<Tasks> tasksPaginadas(int limite, int paginaAtual, String ordenacao);

    List<Tasks> buscarTasks(String parametro);

    Tasks findTaskById(int id_task);

    Boolean inserirTask(Tasks task);

    Boolean modificarTask(Tasks task, int id_task);

    Boolean deletarTask(int id_task);

    int proximoIdTask();
}

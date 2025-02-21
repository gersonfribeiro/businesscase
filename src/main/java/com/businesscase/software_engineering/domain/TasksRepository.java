package com.businesscase.software_engineering.domain;

import com.businesscase.software_engineering.headerPaginator.HeaderPaginator;

import java.util.List;

public interface TasksRepository {

    public HeaderPaginator<Tasks> tasksPaginadas(int limite, int paginaAtual, String ordenacao);

    public List<Tasks> buscarTasks(String parametro);

    public Tasks findTaskById(int id_task);

    public Boolean inserirTask(Tasks task);

    public Boolean modificarTask(Tasks task, int id_task);

    public Boolean deletarTask(int id_task);
}

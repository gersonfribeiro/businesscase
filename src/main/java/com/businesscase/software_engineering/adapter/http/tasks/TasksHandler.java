package com.businesscase.software_engineering.adapter.http.tasks;

import com.businesscase.software_engineering.application.tasks.TasksService;
import com.businesscase.software_engineering.application.tasks.dtos.TasksCreateCommand;
import com.businesscase.software_engineering.application.tasks.dtos.TasksUpdateCommand;
import com.businesscase.software_engineering.domain.Tasks;
import com.businesscase.software_engineering.headerPaginator.HeaderPaginator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TasksHandler {

    private final TasksService tasksService;

    public TasksHandler(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    public ResponseEntity<HeaderPaginator<Tasks>> tasksPaginadas(int limite, int paginaAtual, String ordenacao) {
        HeaderPaginator<Tasks> registros = tasksService.tasksPaginadas(limite, paginaAtual, ordenacao);
        return ResponseEntity.ok(registros);
    }

    public List<Tasks> buscarTasks(String parametro){
        return tasksService.buscarTasks(parametro);
    }

    public Tasks findTaskById(int id_task){
        return tasksService.findTaskById(id_task);
    }

    public Boolean inserirTask(TasksCreateCommand task){
        return tasksService.inserirTask(task);
    }

    public Boolean modificarTask(TasksUpdateCommand task, int id_task){
        return tasksService.modificarTask(task, id_task);
    }

    public Boolean deletarTask(int id_task){
        return tasksService.deletarTask(id_task);
    }
}

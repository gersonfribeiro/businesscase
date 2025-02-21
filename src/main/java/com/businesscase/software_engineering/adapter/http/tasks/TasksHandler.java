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
        return ResponseEntity.ok(tasksService.tasksPaginadas(limite, paginaAtual, ordenacao));
    }

    public ResponseEntity<List<Tasks>> buscarTasks(String parametro){
        return ResponseEntity.ok(tasksService.buscarTasks(parametro));
    }

    public ResponseEntity<Tasks> findTaskById(int id_task){
        return ResponseEntity.ok(tasksService.findTaskById(id_task));
    }

    public ResponseEntity<Tasks> inserirTask(TasksCreateCommand task){
        return ResponseEntity.ok(tasksService.inserirTask(task));
    }

    public ResponseEntity<Tasks> modificarTask(TasksUpdateCommand task, int id_task){
        return ResponseEntity.ok(tasksService.modificarTask(task, id_task));
    }

    public String deletarTask(int id_task){
        return tasksService.deletarTask(id_task);
    }
}

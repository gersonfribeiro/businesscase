package com.businesscase.software_engineering.adapter.http.tasks;

import com.businesscase.software_engineering.application.tasks.dtos.TasksCreateCommand;
import com.businesscase.software_engineering.application.tasks.dtos.TasksUpdateCommand;
import com.businesscase.software_engineering.domain.Tasks;
import com.businesscase.software_engineering.headerPaginator.HeaderPaginator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private final TasksHandler tasksHandler;

    public TasksController(TasksHandler tasksHandler) {
        this.tasksHandler = tasksHandler;
    }

    public ResponseEntity<HeaderPaginator<Tasks>> tasksPaginadas(int limite, int paginaAtual, String ordenacao) {
        return tasksHandler.tasksPaginadas(limite, paginaAtual, ordenacao);
    }

    public List<Tasks> buscarTasks(String parametro){
        return tasksHandler.buscarTasks(parametro);
    }

    public Tasks findTaskById(int id_task){
        return tasksHandler.findTaskById(id_task);
    }

    public Boolean inserirTask(TasksCreateCommand task){
        return tasksHandler.inserirTask(task);
    }

    public Boolean modificarTask(TasksUpdateCommand task, int id_task){
        return tasksHandler.modificarTask(task, id_task);
    }

    public Boolean deletarTask(int id_task){
        return tasksHandler.deletarTask(id_task);
    }
}

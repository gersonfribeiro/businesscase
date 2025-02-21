package com.businesscase.software_engineering.application.tasks;

import com.businesscase.software_engineering.application.tasks.dtos.TasksCreateCommand;
import com.businesscase.software_engineering.application.tasks.dtos.TasksUpdateCommand;
import com.businesscase.software_engineering.domain.Tasks;
import com.businesscase.software_engineering.domain.TasksRepository;
import com.businesscase.software_engineering.headerPaginator.HeaderPaginator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasksService {

    private final TasksRepository tasksRepository;

    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public HeaderPaginator<Tasks> tasksPaginadas(int limite, int paginaAtual, String ordenacao) {
        return tasksRepository.tasksPaginadas(limite, paginaAtual, ordenacao);
    }

    public List<Tasks> buscarTasks(String parametro){
        return tasksRepository.buscarTasks(parametro);
    }

    public Tasks findTaskById(int id_task){
        return tasksRepository.findTaskById(id_task);
    }

    public Boolean inserirTask(TasksCreateCommand task){
        return tasksRepository.inserirTask(task.toTask());
    }

    public Boolean modificarTask(TasksUpdateCommand task, int id_task){
        return tasksRepository.modificarTask(task.toTask(id_task), id_task);
    }

    public Boolean deletarTask(int id_task){
        return tasksRepository.deletarTask(id_task);
    }
}

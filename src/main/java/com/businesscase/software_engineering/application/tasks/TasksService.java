package com.businesscase.software_engineering.application.tasks;

import com.businesscase.software_engineering.application.tasks.dtos.TasksCreateCommand;
import com.businesscase.software_engineering.application.tasks.dtos.TasksUpdateCommand;
import com.businesscase.software_engineering.application.tasks.exceptions.TaskNotFound;
import com.businesscase.software_engineering.application.tasks.exceptions.TaskNotFoundByParam;
import com.businesscase.software_engineering.application.tasks.exceptions.TasksErrorOnDelete;
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
        List<Tasks> registros = tasksRepository.buscarTasks(parametro);
        if (registros.isEmpty())
            throw new TaskNotFoundByParam(parametro);
        return registros;
    }

    public Tasks findTaskById(int id_task){
        Tasks task = tasksRepository.findTaskById(id_task);
        if (task == null)
            throw new TaskNotFound(id_task);
        return task;
    }

    public Tasks inserirTask(TasksCreateCommand task){
        Tasks taskDomain = task.toTask();
        tasksRepository.inserirTask(taskDomain);
        return findTaskById(taskDomain.getId_task());
    }

    public Tasks modificarTask(TasksUpdateCommand task, int id_task){
        findTaskById(id_task);
        Tasks taskUpdate = task.toTask(id_task);
        tasksRepository.modificarTask(taskUpdate, id_task);
        return taskUpdate;
    }

    public String deletarTask(int id_task){
        findTaskById(id_task);
        Boolean resultOperation = tasksRepository.deletarTask(id_task);
        if (!resultOperation)
            throw new TasksErrorOnDelete(id_task);
        return "Task removida com sucesso!";
    }
}

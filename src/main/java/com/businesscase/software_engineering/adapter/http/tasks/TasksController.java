package com.businesscase.software_engineering.adapter.http.tasks;

import com.businesscase.software_engineering.application.tasks.dtos.TasksCreateCommand;
import com.businesscase.software_engineering.application.tasks.dtos.TasksUpdateCommand;
import com.businesscase.software_engineering.domain.Tasks;
import com.businesscase.software_engineering.headerPaginator.HeaderPaginator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private final TasksHandler tasksHandler;

    public TasksController(TasksHandler tasksHandler) {
        this.tasksHandler = tasksHandler;
    }

    @GetMapping()
    public ResponseEntity<HeaderPaginator<Tasks>> tasksPaginadas(
            @RequestParam(defaultValue = "25") int limite,
            @RequestParam(defaultValue = "1") int paginaAtual,
            @RequestParam(defaultValue = "ASC") String ordenacao
    ) {
        return tasksHandler.tasksPaginadas(limite, paginaAtual, ordenacao);
    }

    @GetMapping("/find")
    public ResponseEntity<List<Tasks>> buscarTasks(@RequestParam String parametro){
        return tasksHandler.buscarTasks(parametro);
    }

    @GetMapping("/find/{id_task}")
    public ResponseEntity<Tasks> findTaskById(@PathVariable int id_task){
        return tasksHandler.findTaskById(id_task);
    }

    @PostMapping()
    public ResponseEntity<Tasks> inserirTask(@RequestBody TasksCreateCommand task){
        return tasksHandler.inserirTask(task);
    }

    @PutMapping("/update/{id_task}")
    public ResponseEntity<Tasks> modificarTask(
            @RequestBody TasksUpdateCommand task,
            @PathVariable int id_task
    ){
        return tasksHandler.modificarTask(task, id_task);
    }

    @DeleteMapping("/delete/{id_task}")
    public String deletarTask(@PathVariable int id_task){
        return tasksHandler.deletarTask(id_task);
    }
}

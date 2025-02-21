package com.businesscase.software_engineering.application.tasks;

import com.businesscase.software_engineering.domain.TasksRepository;
import org.springframework.stereotype.Service;

@Service
public class TasksService {

    private final TasksRepository tasksRepository;

    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }
}

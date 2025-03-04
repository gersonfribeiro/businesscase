package com.businesscase.software_engineering.application.tasks.dtos;

import com.businesscase.software_engineering.domain.Tasks;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TasksCreateCommand {
    @JsonProperty("title_task")
    private String title_task;

    @JsonProperty("description_task")
    private String description_task;

    public Tasks toTask() {
        return new Tasks(title_task, description_task);
    }

    public TasksCreateCommand(String title_task, String description_task) {
        this.title_task = title_task;
        this.description_task = description_task;
    }
}

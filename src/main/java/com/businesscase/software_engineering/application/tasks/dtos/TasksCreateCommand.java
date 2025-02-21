package com.businesscase.software_engineering.application.tasks.dtos;

import com.businesscase.software_engineering.domain.Status_tasks;
import com.businesscase.software_engineering.domain.Tasks;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TasksCreateCommand {

    @JsonProperty("title_task")
    private String title_task;

    @JsonProperty("description_task")
    private String description_task;

    @JsonProperty("status_task")
    private Status_tasks status_task;

    public Tasks toTask() {
        return new Tasks(title_task, description_task, status_task);
    }
}

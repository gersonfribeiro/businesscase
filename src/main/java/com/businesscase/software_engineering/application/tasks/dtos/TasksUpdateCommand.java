package com.businesscase.software_engineering.application.tasks.dtos;

import com.businesscase.software_engineering.domain.Status_tasks;
import com.businesscase.software_engineering.domain.Tasks;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class TasksUpdateCommand {
    @JsonProperty("title_task")
    private String title_task;

    @JsonProperty("description_task")
    private String description_task;

    @JsonProperty("status_task")
    private Status_tasks status_task;

    @JsonProperty("data_task")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date data_task;

    public Tasks toTask(int id_task) {
        return new Tasks(id_task, title_task, description_task, status_task, data_task);
    }

    public TasksUpdateCommand(String title_task, String description_task, Status_tasks status_task, Date data_task) {
        this.title_task = title_task;
        this.description_task = description_task;
        this.status_task = status_task;
        this.data_task = data_task;
    }
}

package com.businesscase.software_engineering.application.tasks.dtos;

import com.businesscase.software_engineering.domain.Status_tasks;
import com.businesscase.software_engineering.domain.Tasks;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class TasksUpdateCommand {

    @JsonProperty("title_task")
    private String title_task;

    @JsonProperty("description_task")
    private String description_task;

    @JsonProperty("status_task")
    private Status_tasks status_task;

    @JsonProperty("data_task")
    private Date data_task;

    public Tasks toTask(int id_task) {
        return new Tasks(id_task, title_task, description_task, status_task, data_task);
    }
}

package com.businesscase.software_engineering.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Tasks {
    @JsonProperty("id_task")
    private int id_task;

    @JsonProperty("title_task")
    private String title_task;

    @JsonProperty("description_task")
    private String description_task;

    @JsonProperty("status_task")
    private Status_tasks status_task;

    @JsonProperty("data_task")
    private Date data_task;

    @JsonProperty("data_modificacao_task")
    private Date data_modificacao_task;


    public Tasks(int id_task, String title_task, String description_task, Status_tasks status_task, Date data_task, Date data_modificacao_task) {
        this.id_task = id_task;
        this.title_task = title_task;
        this.description_task = description_task;
        this.status_task = status_task;
        this.data_task = data_task;
        this.data_modificacao_task = data_modificacao_task;
    }

    // Constructor para post
    public Tasks(String title_task, String description_task) {
        this.title_task = title_task;
        this.description_task = description_task;
        this.status_task = Status_tasks.PENDING;

        LocalDate localDate = LocalDate.now();
        this.data_task = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    // Constructor para put
    public Tasks(int id_task, String title_task, String description_task, Status_tasks status_task, Date data_task) {
        this.id_task = id_task;
        this.title_task = title_task;
        this.description_task = description_task;
        this.status_task = status_task;
        this.data_task = data_task;

        LocalDate localDate = LocalDate.now();
        this.data_modificacao_task = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public int getId_task() {
        return id_task;
    }

    public void setId_task(int id_task) {
        this.id_task = id_task;
    }

    public String getTitle_task() {
        return title_task;
    }

    public void setTitle_task(String title_task) {
        this.title_task = title_task;
    }

    public String getDescription_task() {
        return description_task;
    }

    public void setDescription_task(String description_task) {
        this.description_task = description_task;
    }

    public Status_tasks getStatus_task() {
        return status_task;
    }

    public void setStatus_task(Status_tasks status_task) {
        this.status_task = status_task;
    }

    public Date getData_task() {
        return data_task;
    }

    public void setData_task(Date data_task) {
        this.data_task = data_task;
    }

    public Date getData_modificacao_task() {
        return data_modificacao_task;
    }

    public void setData_modificacao_task(Date data_modificacao_task) {
        this.data_modificacao_task = data_modificacao_task;
    }
}

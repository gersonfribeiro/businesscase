package com.businesscase.software_engineering.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor // será utilizado no RowMapper
public class Tasks {
    private int id_task;
    private String title_task;
    private String description_task;
    private Status_tasks status_task;
    private Date data_task;
    private Date data_modificacao_task;

    // Constructor para post
    public Tasks(int id_task, String title_task, String description_task, Status_tasks status_task) {
        this.id_task = id_task;
        this.title_task = title_task;
        this.description_task = description_task;
        this.status_task = status_task;

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
}

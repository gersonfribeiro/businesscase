package com.businesscase.software_engineering.adapter.http.exception_handlers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {

    @JsonProperty("message")
    private String message;

    @JsonProperty("id_task")
    private int id_task;

    @JsonProperty("parametro")
    private String parametro;

    @JsonProperty("status")
    private int status;

    public ErrorResponse() {}

    public void setMessage(String message) {
        this.message = message;
    }

    public void setId_task(int id_task) {
        this.id_task = id_task;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

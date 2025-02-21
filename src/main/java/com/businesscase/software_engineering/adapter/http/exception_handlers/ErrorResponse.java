package com.businesscase.software_engineering.adapter.http.exception_handlers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResponse {

    @JsonProperty("message")
    private String message;

    @JsonProperty("id_task")
    private int id_task;

    @JsonProperty("parametro")
    @JsonIgnore
    private String parametro;

    @JsonProperty("status")
    private int status;
}

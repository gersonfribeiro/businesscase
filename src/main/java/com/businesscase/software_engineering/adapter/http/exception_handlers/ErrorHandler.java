package com.businesscase.software_engineering.adapter.http.exception_handlers;

import com.businesscase.software_engineering.application.tasks.exceptions.TaskNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(TaskNotFound.class)
    public ResponseEntity<ErrorResponse> handleTaskNotFound(TaskNotFound e) {
        ErrorResponse errorResponse = new ErrorResponse(
                e.getMessage(),
                e.getId_task(),
                HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}

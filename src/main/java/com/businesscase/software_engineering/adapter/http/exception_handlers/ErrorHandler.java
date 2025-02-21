package com.businesscase.software_engineering.adapter.http.exception_handlers;

import com.businesscase.software_engineering.application.tasks.exceptions.TaskNotFound;
import com.businesscase.software_engineering.application.tasks.exceptions.TaskNotFoundByParam;
import com.businesscase.software_engineering.application.tasks.exceptions.TasksErrorOnDelete;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(TaskNotFound.class)
    public ResponseEntity<ErrorResponse> handleTaskNotFound(TaskNotFound e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setId_task(e.getId_task());
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TaskNotFoundByParam.class)
    public ResponseEntity<ErrorResponse> handleTaskNotFoundByParam(TaskNotFoundByParam e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setParametro(e.getParametro());
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TasksErrorOnDelete.class)
    public ResponseEntity<ErrorResponse> handleTasksErrorOnDelete(TasksErrorOnDelete e) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setId_task(e.getId_task());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}

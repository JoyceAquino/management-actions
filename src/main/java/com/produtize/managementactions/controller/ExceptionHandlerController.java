package com.produtize.managementactions.controller;

import com.produtize.managementactions.exception.ResponseError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.joining;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ConversionFailedException.class)
    public ResponseEntity<?> handleConversionFailedException(ConversionFailedException exception) {
        String message = String.format("%s valor invalido", Objects.requireNonNull(exception.getValue()).toString());
        ResponseEntity<Object> responseEntity = createResponseEntity(UNPROCESSABLE_ENTITY, message);
        log.info(Objects.requireNonNull(responseEntity.getBody()).toString());
        return responseEntity;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ResponseEntity<Object> responseEntity = createResponseEntity(UNPROCESSABLE_ENTITY, formatMessageMethodArgumentNotValidException(ex));
        log.info(Objects.requireNonNull(responseEntity.getBody()).toString());
        return responseEntity;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(HttpMessageNotReadableException e) {
        ResponseEntity<Object> responseEntity = createResponseEntity(BAD_REQUEST, e.getMessage());
        log.info(Objects.requireNonNull(responseEntity.getBody()).toString());
        return responseEntity;
    }

    private ResponseEntity<Object> createResponseEntity(HttpStatus status, String message) {
        ResponseError errorMessage = ResponseError.builder()
                .status(status)
                .error(status.value())
                .message(message)
                .build();
        return new ResponseEntity<>(errorMessage, status);
    }
    private String formatMessageMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        String fields = fieldErrors.stream()
                .map(FieldError::getField)
                .collect(joining(","));

        String fieldsMessages = fieldErrors.stream()
                .map(FieldError::getDefaultMessage)
                .distinct()
                .collect(joining(","));
        return String.format("%s %s", fields, fieldsMessages);
    }

}

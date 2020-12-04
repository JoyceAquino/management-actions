package com.produtize.managementactions.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ResponseError {

    private HttpStatus status;
    private int error;
    private String message;

    @Override
    public String toString() {
        return "{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}

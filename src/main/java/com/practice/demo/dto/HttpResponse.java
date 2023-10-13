package com.practice.demo.dto;

import com.practice.demo.enums.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HttpResponse {

    private String message;
    private int code;

    public HttpResponse(HttpStatus status) {
        message = status.getMessage();
        this.code = status.getCode();
    }
}

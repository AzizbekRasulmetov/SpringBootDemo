package com.practice.demo.enums;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum HttpStatus {

    //2xx Successful
    SUCCESS(200, "Sucess"),
    CREATED(201, "Created"),
    ACCEPTED(202, "Accepted"),

    //4xx Client Errors
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),

    //5xx Server Errors
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    BAD_GATEWAY(502, "Bad Gateway"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable");

    private final int code;
    private final String message;

    HttpStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

}

package com.management.system.demo.exception;

import java.util.Date;

public class ExceptionResponse {

    public Date timestamp;
    public String message;
    public String detail;

    public ExceptionResponse(Date timestamp, String message, String detail) {
        this.timestamp = timestamp;
        this.message = message;
        this.detail = detail;
    }
}

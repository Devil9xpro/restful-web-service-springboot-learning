package com.example.restfulwebservicespringbootlearning.entity;

import java.util.Date;

public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;

    public ExceptionResponse() {
    }

    public ExceptionResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public ExceptionResponse timestamp(Date timestamp) {
        setTimestamp(timestamp);
        return this;
    }

    public ExceptionResponse message(String message) {
        setMessage(message);
        return this;
    }

    public ExceptionResponse details(String details) {
        setDetails(details);
        return this;
    }

    @Override
    public String toString() {
        return "{" + " timestamp='" + getTimestamp() + "'" + ", message='" + getMessage() + "'" + ", details='"
                + getDetails() + "'" + "}";
    }

}

package com.revature.taskmaster.dtos;

import java.time.LocalDateTime;

public class ErrorResponse {

    private int code;
    private String message;
    private String timestamp;

    public ErrorResponse(int code, String message) {
        this.code = code;
        this.message = message;
        this.timestamp = LocalDateTime.now().toString();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }

}

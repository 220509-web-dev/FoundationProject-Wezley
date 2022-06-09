package com.revature.taskmaster.exceptions;

public class BadRequestException extends RuntimeException {

    public BadRequestException() {
        super("The provided request data was invalid and the operation could not be completed.");
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

}

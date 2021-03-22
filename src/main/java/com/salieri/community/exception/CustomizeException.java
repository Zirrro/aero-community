package com.salieri.community.exception;

/**
 * @author Salieri
 * @date 3/22/2021 2:28 PM
 */
public class CustomizeException extends RuntimeException{
    private String message;

    public  CustomizeException(ICustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }

    public  CustomizeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

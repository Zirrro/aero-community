package com.salieri.community.exception;

/**
 * @author Salieri
 * @date 3/22/2021 2:28 PM
 */
public class CustomizeException extends RuntimeException{
    private String message;
    private Integer code;

    public  CustomizeException(ICustomizeErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}

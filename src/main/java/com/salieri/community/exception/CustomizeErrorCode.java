package com.salieri.community.exception;

/**
 * @author Salieri
 * @date 3/22/2021 3:23 PM
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_MOT_FOUND("找不到问题");
    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

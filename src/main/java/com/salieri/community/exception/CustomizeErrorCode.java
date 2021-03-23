package com.salieri.community.exception;

/**
 * @author Salieri
 * @date 3/22/2021 3:23 PM
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUND(2001, "找不到问题"),
    TARGET_PARAM_NOT_FOUND(2002, "未选中问题或评论进行回复"),
    NO_LOGIN(2003, "未登录无法评论，请先登录"),
    SYS_ERROR(2004, "服务器冒烟了..."),
    TYPE_PARAM_WRONG(2005, "评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2006, "你回复的评论不存在了"),
    ;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }
}

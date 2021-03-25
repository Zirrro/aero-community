package com.salieri.community.enums;

/**
 * @author Salieri
 * @date 3/23/2021 10:58 PM
 */
public enum CommentTypeEnum {
    QUESTION(1),
    COMMENT(2);

    private Integer type;

    public Integer getType() {
        return type;
    }

    CommentTypeEnum(Integer type) {
        this.type = type;
    }

    public static boolean isExist(Integer type) {
        for (CommentTypeEnum commentTypeEnum : CommentTypeEnum.values()) {
            if (commentTypeEnum.getType().equals(type)) {
                return true;
            }
        }
        return false;
    }
}

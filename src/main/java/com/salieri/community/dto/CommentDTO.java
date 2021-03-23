package com.salieri.community.dto;

import lombok.Data;

/**
 * @author Salieri
 * @date 3/23/2021 6:32 PM
 */
@Data
public class CommentDTO {
    private Long parentId;
    private String content;
    private Integer type;
}

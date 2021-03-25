package com.salieri.community.dto;

import com.salieri.community.model.User;
import lombok.Data;

/**
 * @author Salieri
 * @date 3/26/2021 2:49 AM
 */
@Data
public class CommentDTO {
    private Long id;

    private Long parentId;

    private Integer type;

    private Long commentator;

    private Long gmtCreate;

    private Long gmtModified;

    private Long likeCount;

    private String content;

    private User user;
}

package com.salieri.community.mapper;

import com.salieri.community.model.Question;

public interface QuestionExtMapper {
    int incView(Question record);

    int incCommentCount(Question record);
}
package com.salieri.community.mapper;

import com.salieri.community.model.Question;
import com.salieri.community.model.QuestionExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface QuestionExtMapper {
    int incView (Question record);
}
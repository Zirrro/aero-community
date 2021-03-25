package com.salieri.community.controller;

import com.salieri.community.dto.CommentDTO;
import com.salieri.community.dto.QuestionDTO;
import com.salieri.community.service.CommentService;
import com.salieri.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Long id,
                           Model model) {
        QuestionDTO questionDTO = questionService.getById(id);

        List<CommentDTO> comments = commentService.listByQuestionId(id);

        // 累加阅读数
        questionService.incView(id);
        model.addAttribute("question", questionDTO);  //通过attribute写入页面
        model.addAttribute("comments", comments);
        return "question";
    }
}

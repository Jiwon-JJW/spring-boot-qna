package com.codessquad.qna.web;

import com.codessquad.qna.domain.Question;
import com.codessquad.qna.service.QuestionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MainController {
    private final QuestionService questionService;

    public MainController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @GetMapping("/")
    public String viewHomePage(Model model) {
        return listByPage(1, model);
    }


    @GetMapping("/page/{pageNumber}")
    public String listByPage(@PathVariable("pageNumber")int pageNumber, Model model) {
        Page page = questionService.questionListAll(pageNumber);
        Pageable pageable = page.getPageable();
        PageList pageList = new PageList(page, pageable);
        model.addAttribute("totalPages", pageList);
        model.addAttribute("question", page.getContent());
        return "index";
    }
}

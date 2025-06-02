package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ArticleController {

    @GetMapping("articles/new")
    public String newArticleForm() {

        log.info("New article form");
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm articleForm) {
        log.info("New article created");
        log.info("article form: {}", articleForm);

        return null;
    }
}

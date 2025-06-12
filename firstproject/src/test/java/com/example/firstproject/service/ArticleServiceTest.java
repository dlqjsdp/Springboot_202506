package com.example.firstproject.service;

import com.example.firstproject.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Slf4j
class ArticleServiceTest {

    @Autowired
    ArticleService articleService;

    @Test
    void index() {

        // 1. 예상 데이터

        // 2. 실제 데이터

        // 3. 비교 및 검증
    }

    @Test
    void show_성공() {
        // id : 202
        //"title": "5555",
        // "content": "5555"

        // 1. 예상 데이터
        Article expected = new Article(202L, "5555", "5555");

        // 2. 실제 데이터
        Article article = articleService.show(202L);

        // 3. 비교 및 검증
        assertEquals(expected.toString(), article.toString());
//        log.info("article = {}", article);
    }

    @Test
    void show_실패() {
        // id : 202
        //"title": "5555",
        // "content": "5555"

        // 1. 예상 데이터
        Article expected = new Article(202L, "5555", "6666");

        // 2. 실제 데이터
        Article article = articleService.show(202L);

        // 3. 비교 및 검증
        assertEquals(expected.toString(), article.toString());
//        log.info("article = {}", article);
    }
}
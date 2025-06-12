package com.example.firstproject.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentRepositoryTest {

    @Autowired
    private CommentRepository comment;

//    @Test
//    void findByArticleID() {
//
////        comment.findByArticleId(1L)
////                .forEach(System.out::println);
//
////        .forEach(commment -> System.out.println(commment))
//
////        comment.findByBodyOrNickname("굿 윌 헌팅", "Choi")
////                .forEach(System.out::println);
//
//        comment.findByNickname("Kim")
//                .forEach(System.out::println);
//    }


        @Test
        @DisplayName("특정 게시글 닉네임으로 조회")
        void findByArticleID() {

            comment.findByNickname("Kim")
                    .forEach(System.out::println);
        }


}
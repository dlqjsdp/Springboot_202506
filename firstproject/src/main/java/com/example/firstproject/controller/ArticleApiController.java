package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class ArticleApiController {

//  @Autowired // 생성자 주입은 @Autowired 방식보다 @RequiredArgsConstructor를 더 선호함.
//    private final ArticleRepository articleRepository;
    private final ArticleService articleService;

    // GET	/api/articles	모든 게시글 목록 가져오기
    @GetMapping("/articles")
    public List<Article> index() {
        log.info("restapi index");
        return articleService.index();
    }

    // GET	/api/articles/{id}	특정 ID 게시글 상세 조회
    @GetMapping("/articles/{id}")
    public Article show(@PathVariable Long id) {

        return articleService.show(id);
    }

    // POST	/api/articles	새 게시글 등록 (JSON body로 전송)
    @PostMapping("/articles")
    public ResponseEntity<Article> create(@RequestBody ArticleForm dto) {

        Article created = articleService.create(dto);

        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST). build();
    }

    // PATCH	/api/articles/{id}	기존 게시글의 일부 정보 수정 (부분 수정)
    @PatchMapping("/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto) {

        Article updated = articleService.update(id, dto);

         return (updated != null) ?
                 ResponseEntity.status(HttpStatus.OK).body(updated) :
                 ResponseEntity.status(HttpStatus.BAD_REQUEST). build();
    }

    // DELETE	/api/articles/{id}	특정 ID 게시글 삭제
    @DeleteMapping("/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id) {

        Article deleted = articleService.delete(id);

        return (deleted != null) ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST). build();
    }

    //트랜잭션 연습
    @PostMapping("/transaction-test")
    public ResponseEntity<List<Article>>  transactionTest(@RequestBody List<ArticleForm> dtos) {

        log.info(" restapi transaction test");

        List<Article> createdList =  articleService.createArticles(dtos);

        return (createdList != null) ?
                ResponseEntity.status(HttpStatus.OK).body(createdList) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}

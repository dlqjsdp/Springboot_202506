package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ArticleForm {
    private Long id;
    private String title;
    private String content;

    public Article toEntity() {

        return new Article(id, title, content);
        // 신규 게시글 생성 시 ID는 DB가 자동 생성하기 때문에 null로 사용.
        // 게시글 수정할 때는 id값이 필요해서 null값을 id로 바꿈.
    }

    public List<Article>  toEntity(List<ArticleForm> articles) {

        List list = new ArrayList();

        for(ArticleForm article : articles) {
            list.add( new Article(id, title, content));
        }
        return list;
    }
}

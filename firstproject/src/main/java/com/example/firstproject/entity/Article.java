package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // 테이블로 생성
//@Table(name = "article") 테이블 이름
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //자동생성 기능 추가(숫자가 자동증가)
    private Long id; // 기본키

    @Column
    // (nullable=false) 여기에 이걸 적으면 null값을 허용하지 않는 것이기 때문에
    // 제목에 null값이 있으면 에러남
    private String title;

    private String content;


    public void patch(Article article) {
        if(article.title != null) {
            this.title = article.title;
        }

        if(article.content != null) {
            this.content = article.content;
        }
    }
}

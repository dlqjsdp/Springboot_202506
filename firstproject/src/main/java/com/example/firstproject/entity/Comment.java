package com.example.firstproject.entity;

import com.example.firstproject.dto.CommentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB에서 자동으로 1씩 증가
    private Long id;

    private String nickname;

    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;  // article_id bigint

    public static Comment create(CommentDto dto, Article article) throws IllegalArgumentException {
        // 예외 발생
        if(dto.getId() != null){
            throw new IllegalArgumentException("댓글 생성 실패! 댓글의 id가 없어야 합니다.");
        }

        if(dto.getArticleId() != article.getId()) {
            throw new IllegalArgumentException("댓글 생성 실패! 게시글의 id가 잘못됐습니다.");
        }

        // 엔티티 생성 빛 반환
        return new Comment(dto.getId(), dto.getNickname(), dto.getBody(), article);
    }

    public void patch(CommentDto dto) {
        // 예외 발생
        if(this.id != dto.getId()) {
            throw new IllegalArgumentException("<댓글 수정 실패!, 잘못된 id가 입력됐습니다.");
        }

        // 객체 갱신
        if(dto.getNickname() != null) { // 수정할 nickname 있니?
            this.nickname = dto.getNickname();
        }

        if(dto.getBody() != null) { // 수정할 body 있니?
            this.body = dto.getBody();
        }
    }
}

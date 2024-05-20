package com.example.SSUCout.review;

import com.example.SSUCout.club.Club;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Review {
    @Id
    @Column
    private Integer reviewId;       // 리뷰글 번호

    @Column(columnDefinition = "TEXT")
    private String reviewContent;   // 리뷰 본문

    @Column
    private Double userStar;        // 별점

    @Column
    private Integer userYear;       // 리뷰작성자의 활동연도

    @Column
    private LocalDateTime writeDate; // 리뷰 작성 날짜, 시간

    @ManyToOne          // review:club = many:one
    @JoinColumn(name = "club_id")
    private Club club;
}

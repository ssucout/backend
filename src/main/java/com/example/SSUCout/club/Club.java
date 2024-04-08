package com.example.SSUCout.club;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer clubId;

    @Column
    private String clubName;

    @Column
    private String clubCategory;        // 분과

    @Column
    private Double totalStar;           // 평균 별점

    @Column
    private Integer clubLoc;

    @Column(columnDefinition = "TEXT")
    private String clubInfo;         // 동아리 설명, 요약

//    @OneToMany(mappedBy = "Club", cascade = CascadeType.REMOVE)
//    private List<Review> reviewList;
}
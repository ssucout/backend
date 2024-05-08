package com.example.SSUCout.club;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity(name = "club")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clubId;

    private String clubName;

    private String clubCategory;        // 분과

    private Double totalStar;           // 평균 별점

    private Integer clubLoc;

    private String clubInfo;

//    @OneToMany(mappedBy = "Club", cascade = CascadeType.REMOVE)
//    private List<Review> reviewList;
}

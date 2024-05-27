package com.example.SSUCout.club;

import com.example.SSUCout.review.Review;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @OneToMany(mappedBy = "club", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Review> reviewList;
    public static Club toEntity(ClubDTO dto){
        return Club.builder()
                .clubId(dto.getClubId())
                .clubName(dto.getClubName())
                .clubCategory(dto.getClubCategory())
                .totalStar(dto.getTotalStar())
                .build();
    }
}

package com.example.SSUCout.club;


import com.example.SSUCout.review.Review;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClubDTO {
    private Integer clubId;
    private String clubName;
    private String clubCategory;
    private double totalStar;

    public static ClubDTO toDTO(Club club) {
        ClubDTO dto = new ClubDTO();
        dto.setClubId(club.getId());
        dto.setClubName(club.getClubName());
        dto.setClubCategory(club.getClubCategory());
        dto.setTotalStar(calculateAverageStar(club.getReviewList()));
        return dto;
    }

    public static List<ClubDTO> toDTOs(List<Club> clubs) {
        return clubs.stream()
                .map(ClubDTO::toDTO)
                .collect(Collectors.toList());
    }

    private static double calculateAverageStar(List<Review> reviews) {
        if (reviews.isEmpty()) {
            return 0.0;
        }
        double sum = reviews.stream().mapToDouble(Review::getUserStar).sum();
        return sum / reviews.size();
    }
}

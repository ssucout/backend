package com.example.SSUCout.club;

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
        dto.setClubId(club.getClubId());
        dto.setClubName(club.getClubName());
        dto.setClubCategory(club.getClubCategory());
        dto.setTotalStar(club.getTotalStar());
        return dto;
    }

    public static List<ClubDTO> toDTOs(List<Club> clubs) {
        return clubs.stream()
                .map(ClubDTO::toDTO)
                .collect(Collectors.toList());
    }
}

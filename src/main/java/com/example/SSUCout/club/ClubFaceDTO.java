package com.example.SSUCout.club;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ClubFaceDTO {
    private String clubName;
    private String clubInfo;
    public static ClubFaceDTO toFaceDto(Club club){
        ClubFaceDTO clubFaceDTO = new ClubFaceDTO();
        clubFaceDTO.setClubName(club.getClubName());
        clubFaceDTO.setClubInfo(club.getClubInfo());
        return clubFaceDTO;
    }
}

package com.example.SSUCout.club;

import lombok.Builder;

@Builder
public record ClubGetResponse(
        String clubName,
        String reviewName
) {

    static ClubGetResponse of(Club club)
    {
        return ClubGetResponse.builder()
                .clubName(club.getClubName())
                .reviewName(club.getReviewList().get(0).getReviewContent())
                .build();
    }
}
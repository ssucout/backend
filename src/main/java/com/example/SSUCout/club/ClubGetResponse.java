package com.example.SSUCout.club;

import com.example.SSUCout.review.Review;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

@Builder
public record ClubGetResponse(
        String clubName,
        List<Review> reviewName
) {

    public static ClubGetResponse of(Club club)
    {
        return ClubGetResponse.builder()
                .clubName(club.getClubName())
                .reviewName(club.getReviewList())
                .build();
    }

    public static List<ClubGetResponse> toDtoList(List<Club> clubs){
        return clubs.stream().map(ClubGetResponse::of).collect(Collectors.toList());
    }
}
package com.example.SSUCout.review;

import com.example.SSUCout.club.Club;
import com.example.SSUCout.club.ClubGetResponse;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
//@Getter
public record ReviewPostRequest(
        String content,
        Double userStar,
        Integer userYear
//        LocalDateTime writeDate,
//        Integer clubId
){

//    public static Review toReview(ReviewPostRequest reviewPostRequest)
//    {
//        return Review.builder()
//                .reviewContent(reviewPostRequest.content())
//                .userStar(reviewPostRequest.userStar())
//                .userYear(reviewPostRequest.userYear())
//                .build();
//    }


//    static Review toEntity() {
//        return ReviewPostRequest.builder().clubId();
//
//    }
}
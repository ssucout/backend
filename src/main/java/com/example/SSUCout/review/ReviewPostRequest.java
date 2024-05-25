package com.example.SSUCout.review;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ReviewPostRequest(
        Integer clubId,
        Integer reviewId,
        Double userStar,
        Integer userYear,
        String content,
        LocalDateTime writeDate
){
//    static Review toEntity() {
//        return ReviewPostRequest.builder().clubId();
//
//    }
}
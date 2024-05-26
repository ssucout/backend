package com.example.SSUCout.review;

import java.time.LocalDateTime;

public class ReviewConverter {
    public static Review toReview(ReviewPostRequest request)
    {
        return Review.builder()
                .reviewContent(request.content())
                .userStar(request.userStar())
                .userYear(request.userYear())
                .build();
    }

    public static ReviewResponseDTO.CreateReviewDTO toCreateReviewResultDTO(Review review){
        return ReviewResponseDTO.CreateReviewDTO.builder()
                .reviewId(review.getReviewId())
                .build();
    }
}

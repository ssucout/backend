package com.example.SSUCout.review;

import com.example.SSUCout.club.Club;
import com.example.SSUCout.club.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ClubRepository clubRepository;

    public Optional<Club> getList(Integer clubid){
        return  clubRepository.findById(clubid);
    }

//    public Review createReview(Review review){
//
//    }
/*
    public Review create(Club club, String content, Double userStar){
        Review review = new Review();
        review.setClub(club);
        review.setReviewContent(content);
        review.setUserStar(userStar);
        review.setWriteDate(LocalDateTime.now());

        return this.reviewRepository.save(new Review());
    }*/
}

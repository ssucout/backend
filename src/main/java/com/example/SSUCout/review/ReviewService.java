package com.example.SSUCout.review;

import com.example.SSUCout.club.Club;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

//    public List<Review> getList(Model model, int clubId){
//        return reviewRepository.findAll(Club, clubId);
//    }

    public Review create(Club club, String content, Double userStar){
        Review review = new Review();
        review.setClub(club);
        review.setReviewContent(content);
        review.setUserStar(userStar);
        review.setWriteDate(LocalDateTime.now());

        return this.reviewRepository.save(new Review());
    }
}
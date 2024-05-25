package com.example.SSUCout.review;

import com.example.SSUCout.club.Club;
import com.example.SSUCout.club.ClubRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ClubRepository clubRepository;

    public Optional<Club> getList(Integer clubid){
        return  clubRepository.findById(clubid);
    }

    public Review createReview(int clubId, ReviewPostRequest request){
        try {
            Review review = ReviewConverter.toReview(request);
            review.setClub(clubRepository.findById(clubId).get());
            review.setWriteDate(LocalDateTime.now());
            return reviewRepository.save(review);
        } catch (NoSuchElementException e) {
            log.error("Club not found with id: {}", clubId, e);
            throw e;
        } catch (Exception e) {
            log.error("Error saving review for club with id: {}", clubId, e);
            throw e;
        }
    }
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

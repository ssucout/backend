package com.example.SSUCout.review;

import com.example.SSUCout.club.ClubGetResponse;
import com.example.SSUCout.club.ClubService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ReviewController {

    private final ClubService clubService;
    private final ReviewService reviewService;

//    public ReviewController(ReviewService reviewService, ClubService clubService) {
//        this.clubService = clubService;
//        this.reviewService = reviewService;
//    }


    @GetMapping("/review/{club_id}")
    @ResponseBody
    public ResponseEntity<ClubGetResponse> getClub(@PathVariable("club_id") String clubId) throws Exception {
        return ResponseEntity.ok(
                clubService.getClubById(Integer.parseInt(clubId))
        );
    }

    @PostMapping("/review/{club_id}/write")
    public ResponseEntity<ReviewResponseDTO.CreateReviewDTO> writeReview(
            @PathVariable("club_id")
            String clubId,
            @RequestBody
            ReviewPostRequest request
    ) throws Exception {
        try {
            Review review = reviewService.createReview(Integer.parseInt(clubId), request);
            return ResponseEntity.ok(ReviewConverter.toCreateReviewResultDTO(review));
        } catch (NoSuchElementException e) {
            log.error("Club not found with id: {}", clubId, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            log.error("Error creating review for club with id: {}", clubId, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}

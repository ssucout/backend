package com.example.SSUCout.review;

import com.example.SSUCout.club.ClubGetResponse;
import com.example.SSUCout.club.ClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
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

//    @PostMapping("/review/{club_id}/write")
//    public ResponseEntity<ReviewPostRequest> writeReview(@PathVariable("club_id") String clubId, @RequestBody ReviewPostRequest reviewPostRequest) throws Exception {
//        return RequestEntity.ok(
//                reviewService.createReview(clubId, )
//        );
//    }

/*
    @PostMapping("/review/{clubId}/write")
    public String createReview(Model model, @PathVariable("clubId") int cId,
                               @RequestParam String content,
                               @RequestParam Double userStar){
        Club club = this.clubService.getClub(cId);
        this.reviewService.create(club, content, userStar);
        return String.format("redirect:/review/%d", cId);
    }*/
}

package com.example.SSUCout.review;

import com.example.SSUCout.club.Club;
import com.example.SSUCout.club.ClubService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReviewController {

    private ReviewService reviewService;
    private ClubService clubService;

//    @GetMapping("/review/{clubId}")
//    public List<Review> list(
//            Model model,@PathVariable
//            int clubId
//    ){
//        model.addAttribute("")
//        return reviewService.getList(model,clubId);
//    }

//    @PostMapping("/review/{clubId}/write")
//    public String createReview(Model model, @PathVariable("clubId") int cId,
//                               @RequestParam String content,
//                               @RequestParam Double userStar){
//        Club club = this.clubService.getClub(cId);
//        this.reviewService.create(club, content, userStar);
//        return String.format("redirect:/review/%d", cId);
//    }
}
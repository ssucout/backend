package com.example.SSUCout.club;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/club")
public class ClubApiController {
    private final ClubService clubService;

    @GetMapping("/list")
    public List<ClubView> view(
    ){
        return clubService.all();
    }

}

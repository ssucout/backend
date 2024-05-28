package com.example.SSUCout.club;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/club")
public class ClubApiController {
    @Autowired
    private final ClubService clubService;

    @GetMapping("/list")
    public List<ClubDTO> view(
    ){
        return clubService.listAll();
    }

    @GetMapping("/list/search")
    public List<ClubDTO> searchClubs(
            @RequestParam(name = "term")
            String term
    ){
        return clubService.searchClubs(term);
    }


}

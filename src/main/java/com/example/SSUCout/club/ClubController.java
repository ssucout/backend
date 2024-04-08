package com.example.SSUCout.club;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ClubController {

    private final ClubRepository clubRepository;

    @GetMapping("/")
    public void list(){

    }


}

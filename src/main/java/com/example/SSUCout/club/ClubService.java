package com.example.SSUCout.club;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClubService {
    private final ClubRepository clubRepository;
    public List<ClubView> all() {
        return clubRepository.findAllBy();
    }

}

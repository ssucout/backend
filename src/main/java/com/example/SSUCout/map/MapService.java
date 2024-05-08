package com.example.SSUCout.map;

import com.example.SSUCout.club.Club;
import com.example.SSUCout.club.ClubRepository;
import com.example.SSUCout.map.MapView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MapService {
    private final ClubRepository clubRepository;
    public List<MapView> viewFloor(
            int a, int b
    ) {
        return clubRepository.findAllByClubLocBetween(a,b);
    }
    public Club findById(Integer clubId) {
        return clubRepository.findById(clubId).get();
    }
}

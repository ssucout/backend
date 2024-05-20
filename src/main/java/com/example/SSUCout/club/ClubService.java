package com.example.SSUCout.club;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ClubService {
    private final ClubRepository clubRepository;
    @Transactional
    public List<ClubDTO> listAll() {
        List<Club> clubs = clubRepository.findAll();
        return ClubDTO.toDTOs(clubs);
    }

    public ClubGetResponse getClubById(int id) throws Exception {
        Club club = clubRepository.findById(id)
                .orElseThrow(Exception::new);
        return ClubGetResponse.of(club);
    }
}

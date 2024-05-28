package com.example.SSUCout.club;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ClubService {
    @Autowired
    private final ClubRepository clubRepository;

    public List<ClubDTO> searchClubs(String term) {
        List<Club> clubs = clubRepository.findAllByClubNameContainingOrderByClubName(term);
        return ClubDTO.toDTOs(clubs);
    }


    @Transactional
    public List<ClubDTO> listAll() {
        List<Club> clubs = clubRepository.findAllByOrderByClubCategoryAscClubNameAsc();
        return ClubDTO.toDTOs(clubs);
    }

    public ClubGetResponse getClubById(int id) throws Exception {
        Club club = clubRepository.findById(id)
                .orElseThrow(Exception::new);
        return ClubGetResponse.of(club);
    }

}

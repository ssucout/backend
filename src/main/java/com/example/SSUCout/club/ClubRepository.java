package com.example.SSUCout.club;

import com.example.SSUCout.map.MapView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubRepository extends JpaRepository<Club, Integer> {

    List<Club> findAllByOrderByClubCategoryAscClubNameAsc();
    List<MapView> findAllByClubLocBetweenOrderByClubLoc(int a, int b);
    List<Club> findAllByClubCategory(String clubCategory);
    List<Club> findAllByClubNameContainingOrderByClubName(String term);


}

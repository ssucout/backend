package com.example.SSUCout.club;

import com.example.SSUCout.map.MapView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubRepository extends JpaRepository<Club, Integer> {

    List<ClubView> findAllBy();
    List<MapView> findAllByClubLocBetween(int a, int b);

}

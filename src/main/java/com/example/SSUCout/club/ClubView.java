package com.example.SSUCout.club;

import jakarta.persistence.Entity;
import lombok.*;


public interface ClubView {
    String getClubName();
    String getClubCategory();
    Double getTotalStar();
}

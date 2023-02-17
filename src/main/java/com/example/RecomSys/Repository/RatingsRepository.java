package com.example.RecomSys.Repository;

import com.example.RecomSys.Models.Ratings;
import com.example.RecomSys.Models.RatingsID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingsRepository extends JpaRepository<Ratings, RatingsID> {
}

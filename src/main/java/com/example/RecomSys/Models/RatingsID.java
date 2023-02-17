package com.example.RecomSys.Models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
public class RatingsID implements Serializable {

    private int userId;

    private int movieId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatingsID ratingsID = (RatingsID) o;
        return userId == ratingsID.userId && movieId == ratingsID.movieId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, movieId);
    }
}

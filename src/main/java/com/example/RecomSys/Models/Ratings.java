package com.example.RecomSys.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity (name = "RATINGS")
@IdClass(RatingsID.class)
public class Ratings {

    @Id
    @Column(name = "USERID")
    private int userId;

    @Id
    @Column(name = "MOVIEID")
    private int movieId;

    private int rating;

    private int timestamp;
}

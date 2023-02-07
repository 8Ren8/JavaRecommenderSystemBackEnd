package com.example.RecomSys.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ratings {
    private int userId;

    private int movieId;

    private int rating;

    private int timestamp;
}

package com.example.RecomSys.Models;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movies {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int movieId;

    private String title;

    private String genres;

    private String description;

    private String posterUrl;

    public Movies(String title, String genres, String description, String posterUrl) {
        super();
        this.title = title;
        this.genres = genres;
        this.description = description;
        this.posterUrl = posterUrl;
    }
}

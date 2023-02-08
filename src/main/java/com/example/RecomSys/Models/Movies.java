package com.example.RecomSys.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity (name = "FILTERED_MOVIES_MEDIUM_TMDBID")
public class Movies {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "MOVIES_SEQ")
    @SequenceGenerator(sequenceName = "movies_seq", allocationSize = 1, initialValue = 155000, name = "MOVIES_SEQ")
    private int movieId;

    private String title;

    private String genres;

    private int tmdbId;

    private String description;

    private String posterUrl;

    public Movies(String title, String genres, int tmdbId, String description, String posterUrl) {
        super();
        this.title = title;
        this.genres = genres;
        this.tmdbId = tmdbId;
        this.description = description;
        this.posterUrl = posterUrl;
    }
}

package com.example.RecomSys.Controllers;

import com.example.RecomSys.Models.Ratings;
import com.example.RecomSys.Repository.RatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ratings")
public class RatingsController {

    @Autowired
    private RatingsRepository ratingsRepo;

    //API EndPoint to save new rating
    @PostMapping("/addRating")
    public ResponseEntity<Ratings> addRating(@RequestBody Ratings rating) {
        return new ResponseEntity<Ratings>(ratingsRepo.save(rating), HttpStatus.CREATED);
    }
}

package com.example.RecomSys.Controllers;

import com.example.RecomSys.Models.Movies;
import com.example.RecomSys.Repository.MoviesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MoviesController {

    //Initialize MoviesDAO object
    @Autowired(required = true)
    private MoviesDAO moviesDao;

    //API EndPoint for getting list of movies
    @GetMapping
    public ResponseEntity<List<Movies>> allMovies() {
        return new ResponseEntity<List<Movies>>(moviesDao.movieList(), HttpStatus.OK);
    }

    //API EndPoint for getting one movie based on movie id
    @GetMapping("/{id}")
    public ResponseEntity<Movies> getSingleMovie(@PathVariable int id) {
        return new ResponseEntity<Movies>(moviesDao.getMovie(id), HttpStatus.OK);
    }

    //API EndPoint for getting similar movies based on movie id
    @GetMapping("/similarMovies/{id}")
    public ResponseEntity<List<Movies>> getSimilarMovies(@PathVariable int id) {
        return new ResponseEntity<List<Movies>>(moviesDao.similarMovies(id), HttpStatus.OK);
    }

    //API EndPoint to create and save new movie
    @PostMapping("/addMovie")
    public ResponseEntity<Movies> addMovie(@RequestBody Movies movie) {
        return new ResponseEntity<Movies>(moviesDao.saveMovie(movie), HttpStatus.CREATED);
    }
}

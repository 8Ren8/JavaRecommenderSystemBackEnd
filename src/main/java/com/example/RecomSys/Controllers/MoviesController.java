package com.example.RecomSys.Controllers;

import com.example.RecomSys.Models.Movies;
import com.example.RecomSys.Repository.MoviesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MoviesController {

    @Autowired(required = true)
    private MoviesDAO moviesDao;

    @GetMapping
    public ResponseEntity<List<Movies>> allMovies() {
        return new ResponseEntity<List<Movies>>(moviesDao.movieList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movies> getSingleMovie(@PathVariable int id) {
        return new ResponseEntity<Movies>(moviesDao.getMovie(id), HttpStatus.OK);
    }

    @GetMapping("/similarMovies/{id}")
    public ResponseEntity<List<Movies>> getSimilarMovies(@PathVariable int id) {
        return new ResponseEntity<List<Movies>>(moviesDao.similarMovies(id), HttpStatus.OK);
    }
}

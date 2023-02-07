package com.example.RecomSys;

import static org.junit.jupiter.api.Assertions.*;

import com.example.RecomSys.Models.Movies;
import com.example.RecomSys.Repository.MoviesDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class MoviesDAOTest {

    private MoviesDAO moviesDao;

    @BeforeEach
    void setUp() throws Exception {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@localhost:1521:ORCL");
        datasource.setUsername("hr");
        datasource.setPassword("hr");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        moviesDao = new MoviesDAO(new JdbcTemplate(datasource));
    }

    @Test
    void testMovieList() {
        List<Movies> listMovies = moviesDao.movieList();

        assertFalse(listMovies.isEmpty());
    }

    @Test
    void testSimilarMovieList() {
        List<Movies> listSimilarMovies = moviesDao.similarMovies(110);

        assertFalse(listSimilarMovies.isEmpty());
    }

    @Test
    void testSaveMovie() {
        Movies movie = new Movies("Movie Test", "Comedy|Action", "Movie Test Description", "poster_url");
        moviesDao.saveMovie(movie);
    }

    @Test
    void testGetMovie() {
        int movieId = 5;
        Movies movie = moviesDao.getMovie(movieId);

        assertNotNull(movie);
    }


}

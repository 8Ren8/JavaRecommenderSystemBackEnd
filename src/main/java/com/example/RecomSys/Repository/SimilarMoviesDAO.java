package com.example.RecomSys.Repository;

import com.example.RecomSys.Models.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class SimilarMoviesDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public SimilarMoviesDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> similarMovieList(int id) {
        String column = "ID_" + id;
        String sql = "SELECT MOVIE_ID FROM PEARSONS_CORRELATIONS_LARGE WHERE " + column + " > 0.8 AND MOVIE_ID != " + id;
        List<String> listSimilarMovies = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(String.class));
        return listSimilarMovies;
    }
}

package com.example.RecomSys.Repository;

import com.example.RecomSys.Models.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MoviesDAO {

    @Autowired(required = true)
    private JdbcTemplate jdbcTemplate;

    public MoviesDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Movies> movieList() {
        String sql = "SELECT * FROM MOVIES";
        List<Movies> listMovies = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Movies.class));
        return listMovies;
    }

    public List<Movies> similarMovies(int id) {
        String column = "ID_" + id;
        String sql = ("SELECT MOVIEID, TITLE, GENRES FROM MOVIES M JOIN PEARSONS_CORRELATIONS_LARGE PCL ON M.MOVIEID = PCL.MOVIE_ID WHERE PCL." + column + " > 0.5 AND MOVIE_ID != " + id);
        List<Movies> listSimilarMovies = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Movies.class));
        return listSimilarMovies;
    }

    public void saveMovie(Movies movie) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("MOVIES").usingColumns("title", "genres", "description", "posterurl");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(movie);
        insertActor.execute(param);
    }

    public Movies getMovie(int id) {
        String sql = "SELECT * FROM MOVIES WHERE movieId = ?";
        Object[] args = {id};
        Movies movie = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Movies.class));

        return movie;
    }

    public void updateMovie(Movies movie) {

    }

    public void deleteMovie(int id) {

    }

}

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

    //Initialize JdbcTemplate Object
    @Autowired(required = true)
    private JdbcTemplate jdbcTemplate;

    //Constructor
    public MoviesDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Get list of movies from database
    public List<Movies> movieList() {
        String sql = "SELECT * FROM FILTERED_MOVIES_MEDIUM_TMDBID";
        List<Movies> listMovies = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Movies.class));
        return listMovies;
    }

    //Get list of similar movies based on movie id from database
    public List<Movies> similarMovies(int id) {
        String column = "ID_" + id;
        String sql = ("SELECT MOVIEID, TITLE, GENRES, TMDBID FROM FILTERED_MOVIES_MEDIUM_TMDBID M JOIN PEARSONS_CORRELATIONS_LARGE PCL ON M.MOVIEID = PCL.MOVIE_ID WHERE PCL." + column + " > 0.6 AND MOVIE_ID != " + id + " AND ROWNUM < 6");
        List<Movies> listSimilarMovies = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Movies.class));
        return listSimilarMovies;
    }

    // Save new movie data into database
    public Movies saveMovie(Movies movie) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("FILTERED_MOVIES_MEDIUM_TMDBID").usingColumns("title", "genres", "tmdbId", "description", "posterurl");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(movie);
        insertActor.execute(param);

        return movie;
    }

    //Get one movie data from database based on movie id
    public Movies getMovie(int id) {
        String sql = "SELECT * FROM FILTERED_MOVIES_MEDIUM_TMDBID WHERE movieId = ?";
        Object[] args = {id};
        Movies movie = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Movies.class));

        return movie;
    }

    //Update data of movie in database
    public void updateMovie(Movies movie) {
        //Yet to be implemented
    }

    //Delete data of movie in database
    public void deleteMovie(int id) {
        //Yet to be implemented
    }

}

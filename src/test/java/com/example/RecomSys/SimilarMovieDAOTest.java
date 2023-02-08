package com.example.RecomSys;

import com.example.RecomSys.Repository.SimilarMoviesDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class SimilarMovieDAOTest {

    private SimilarMoviesDAO similarMoviesDAO;

    @BeforeEach
    void setUp() throws Exception {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@localhost:1521:ORCL");
        datasource.setUsername("hr");
        datasource.setPassword("hr");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        similarMoviesDAO = new SimilarMoviesDAO(new JdbcTemplate(datasource));
    }

    @Test
    void testSimilarMovieList() {
        int movieId = 110;
        List<String> listSimilarMovies = similarMoviesDAO.similarMovieList();

        assertFalse(listSimilarMovies.isEmpty());
    }
}

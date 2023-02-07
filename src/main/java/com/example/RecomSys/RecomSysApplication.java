package com.example.RecomSys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class RecomSysApplication{

	@Autowired(required = true)
	private JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(RecomSysApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		String sql = "SELECT * FROM RATINGS WHERE userId = 11";
//
//		List<Ratings> ratings = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Ratings.class));
//		ratings.forEach(System.out :: println);
//
//		System.exit(0);
//	}
}

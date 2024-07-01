package com.kh.spring04.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring04.mapper.BookMapper;

@Repository
public class BookDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private BookMapper mapper;

}

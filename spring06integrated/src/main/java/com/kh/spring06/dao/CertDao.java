package com.kh.spring06.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring06.dto.CertDto;
import com.kh.spring06.mapper.CertMapper;
@Repository
public class CertDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private CertMapper certMapper;
	
	
	public void insert(CertDto certDto) {
		String sql = "insert into cert(cert_email, cert_number) values(?, ?)";
		Object[] data = {certDto.getCertEmail(), certDto.getCertNumber()};
		jdbcTemplate.update(sql, data);
	}
	public boolean delete(String certEmail) {
		String sql = "delete cert where cert_email = ?";
		Object[] data = {certEmail};
		return jdbcTemplate.update(sql, data) > 0;
	}
	
	//이메일과 인증번호가 유효한지 검사하는 기능
	public boolean check(CertDto certDto, int duration) {
		String sql = "select * from cert "
									+ "where "
										+ "cert_email=? "
										+ "and cert_number=? "
										+ "and cert_time between sysdate-?/24/60 and sysdate";
		Object[] data = {certDto.getCertEmail(), certDto.getCertNumber(), duration};
		List<CertDto> list = jdbcTemplate.query(sql, certMapper, data);
		return list.size() > 0;
		
	}
}

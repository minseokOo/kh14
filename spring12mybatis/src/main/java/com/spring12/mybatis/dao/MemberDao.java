package com.spring12.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring12.mybatis.dto.MemberDto;
import com.spring12.mybatis.vo.MemberComplexRequestVO;

@Repository
public class MemberDao {
	@Autowired
	private  SqlSession sqlSession;
	
	
	public List<MemberDto> complexSearch(MemberComplexRequestVO vo){
		return sqlSession.selectList("member.complexSearch", vo);
	}
}

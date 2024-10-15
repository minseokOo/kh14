package com.spring12.restapi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring12.restapi.dto.WebsocketMessageDto;
import com.spring12.restapi.vo.WebsocketMessageVO;

@Repository
public class WebsocketMessageDao {
	@Autowired
	private SqlSession sqlSession;
	public int sequence() {
		return sqlSession.selectOne("websocketMessage.sequence");
	}
	public void insert(WebsocketMessageDto websocketMessageDto) {
		sqlSession.insert("websocketMessage.add", websocketMessageDto);
	}
	public List<WebsocketMessageDto> selectList(int beginRow, int endRow) {
		Map<String, Object> params = 
								Map.of("beginRow", beginRow, "endRow", endRow);
		return sqlSession.selectList("websocketMessage.list", params);
	}
	
	public List<WebsocketMessageDto> selectListMember(String memberId, int beginRow, int endRow){
		Map<String, Object> params = new HashMap<>();
		params.put("memberId", memberId);
		params.put("beginRow", beginRow);
		params.put("endRow", endRow);
		return sqlSession.selectList("websocketMessage.listMember", params);
	}
	
	public List<WebsocketMessageVO> selectListMemberComplete(String memberId, int beginRow, int endRow){
		Map<String, Object> params = new HashMap<>();
		params.put("memberId", memberId);
		params.put("beginRow", beginRow);
		params.put("endRow", endRow);
		return sqlSession.selectList("websocketMessage.listMemberComplete", params);
	};
}

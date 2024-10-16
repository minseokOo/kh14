package com.spring12.restapi.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring12.restapi.dto.RoomMessageDto;
import com.spring12.restapi.vo.WebsocketMessageVO;

@Repository
public class RoomMessageDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int sequence() {
		return sqlSession.insert("roomMessage.sequence");
	}
	public void insert(RoomMessageDto roomMessageDto) {
		sqlSession.insert("roomMessage.add", roomMessageDto);
	}
	
	//최초 입장 시 전달할 메세지 조회
	public List<WebsocketMessageVO> selectListMemberComplete(String memberId, int beginRow, int endRow, int roomNo){
		Map<String, Object> params = new HashMap<>();
		params.put("memberId", memberId);
		params.put("beginRow", beginRow);
		params.put("endRow", endRow);
		params.put("roomNo", roomNo);
		return sqlSession.selectList("roomMessage.listMemberComplete", params);
	}
	// 더보기 누를 경우 전달할 메세지 조회
	public List<WebsocketMessageVO> selectListMemberComplete(String memberId, int beginRow, int endRow, int firstMessageNo, int roomNo){
		Map<String, Object> params = new HashMap<>();
		params.put("memberId", memberId);
		params.put("beginRow", beginRow);
		params.put("endRow", endRow);
		params.put("firstMessageNo", firstMessageNo);
		params.put("roomNo", roomNo);
		return sqlSession.selectList("roomMessage.listMemberComplete", params);
	}
}

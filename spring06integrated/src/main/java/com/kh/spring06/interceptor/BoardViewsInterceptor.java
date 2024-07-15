package com.kh.spring06.interceptor;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring06.dao.BoardDao;
import com.kh.spring06.dto.BoardDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Service
public class BoardViewsInterceptor implements HandlerInterceptor {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//상황에 맞는 조회수 증가 처리
		// 1. 비회원이 글을 읽는 경우는 조회수 증가 방지
		// 2. 본인 글을 읽는 경우는 조회수 증가 방지
		// 3. 세션에 읽은 글 번호를 저장하도록 구현하고 조회수 증가 방지
		// - 세션에 저장소를 하나 만들어두고 읽은 글 번호를 모두 저장
		// - HashSet<Integer> 형태의 저장소를 history라는 이름에 저장
		
		HttpSession session = request.getSession();
		String createdUser = (String)session.getAttribute("createdUser");
		if(createdUser == null) {// 1
			return true;
		}
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if(createdUser.equals(boardDto.getBoardWriter())) {
		return true;
		}
		
		// 3
		// 3-1. 세션의 시작과 끝을 알 수 없기 때문에 저장소가 있는지 먼저 확인한다.
		// 3-2. 있으면 그대로 이어서 쓰고 없으면 생성한다.
		// 3-3. 현재 글 번호를 추가한다.
		// 3-4. 다음을 위해 세션의 상태를 갱신한다. (생략 가능)
		Set<Integer> history = (Set<Integer>)session.getAttribute("history");
		if(history == null) {
			history = new HashSet<>();
		}
		
//		if(history.contains(boardNo) == false) { //읽은적이 없다면(기록에 없다면)
		if(history.add(boardNo)) { //3-3
		boardDao.updateBoardViews(boardNo);
		}
		
//		session.setAttribute("history", history); //3-4
		
		return true; //무조건 통과
	}
}

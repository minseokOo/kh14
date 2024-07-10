package com.kh.spring06.interceptor;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Service
public class AdminInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String createdLevel = (String)session.getAttribute("createdLevel");
//		System.out.println("createdLevel" + createdLevel);
		
//		boolean isDev = createdLevel.equals("관리자");
		boolean isDev = createdLevel != null && createdLevel.equals("관리자"); //제일 많이 이용
//		boolean isDev = "관리자".equals(createdLevel);
		
		if(isDev) {
			return true;
		}
		else {
		response.sendError(403); //권한 없음(부족), Forbidden
		return false;
		}
	}
}

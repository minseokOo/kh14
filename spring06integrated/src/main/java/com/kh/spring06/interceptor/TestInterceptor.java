package com.kh.spring06.interceptor;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/*
인터셉터(Interceptor)

스프링에서 특정 주소에 대한 처리 과정에 개입할 수 있는 간섭 도구(AOP 구현체)
AOP는 OOP보다 상위 개념 (관점에 의한 간섭)

만드는 방법
1. 상속을 받아서 자격을 획득 (역할이 고정된 도구들은 상속이 필요)
 - HandlerInterceptor
2. 스프링에 등록
3. 필요한 메소드를 재정의
 - preHandle - 요청 처리 시작 전
 - postHandle - 요청 처리 진행 중
 - afterCompletion - 요청 처리 진행 완료
 4. 설정파일을 만들어서 특정 주소를 간섭하도록 코드를 작성
*/
@Service
public class TestInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(
			HttpServletRequest request, //요청 정보 객체 (파라미터, 세션, 쿠키 등)
			HttpServletResponse response, //응답 정보 객체 (사용자에게 보낼 내용)
			Object handler //이제 막 실행되려고 하는 컨트롤러 매핑 정보
			)
			throws Exception {
		System.out.println("테스트 인터셉터");
		
		//파라미터 추출 (주의사항 : String으로 밖에 추출이 안되고 변환은 self)
		//String memberId = 사용자가 보낸 주소에 있는 memberId 파라미터;
		String memberId = request.getParameter("memberId");
		System.out.println("memberId = " + memberId);
		
		// 세션 정보 조회
		HttpSession session = request.getSession();
		String createdUser = (String)session.getAttribute("createdUser");
		System.out.println("createdUser = " + createdUser);
		
		return true; //통과
		
		//사용자에게 제시할 수 있는 작업
		// (1) 리다이렉트
//		response.sendRedirect("/");//메인페이지로 나가
		// (2) 에러 전송
//		response.sendError(500, "미안");
//		return false; //차단
	}

}

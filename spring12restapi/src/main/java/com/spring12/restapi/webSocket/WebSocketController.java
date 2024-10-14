package com.spring12.restapi.webSocket;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.spring12.restapi.service.TokenService;
import com.spring12.restapi.vo.MemberClaimVO;
import com.spring12.restapi.vo.WebSocketRequestVO;
import com.spring12.restapi.vo.WebSocketResponseVO;

/**
 	웹소켓 요청을 처리하기 위한 컨트롤러
 	- SockJS와 STOMP를 사용하면 웹소켓을 HTTP처럼 관리 할 수 있다.
 	- @Controller 를 이용하여 메세지를 매핑하고 채널에 전송 할 수 있다.
 	- 이 컨트롤러에서는 stomp client가 publish한 정보만 받을  수 있다.
 */

@Controller
public class WebSocketController {

	// [1] /app/chat 이라는 채널로 메세지가 들어오면 /public/chat 으로 전송한다.
	
	//업그레이드 전
	
//	@MessageMapping("/chat")//사용자가 /app/chat으로 메세지를 보내면~
//	@SendTo("/public/chat")//그 메세지를 /public/chat으로 보내세요.
//	public WebSocketResponseVO chat(WebSocketRequestVO message) {
//	WebSocketResponseVO response = new WebSocketResponseVO();
//	response.setContent(message.getContent());
//	response.setTime(LocalDateTime.now());
//	return response;
//	
//}
	
	//업그레이드 후
	
	//전송 도구 생성
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	@Autowired
	private TokenService tokenService;
	
	
	
	
	//사용자가 보내는 내용뿐 아니라 헤더 등 모든 정보를 얻고 싶다면 수신 형태를 바꿔야한다.
	//Message<수신 데이터 자료형>
	//헤더와 바디를 각각 읽을 수 있게 되어서 여러 가지 추가 작업이 가능하다.
	@MessageMapping("/chat")//사용자가 /app/chat으로 메세지를 보내면~
	public void chat(Message<WebSocketRequestVO> message) {
		//헤더 추출
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
		String accessToken = accessor.getFirstNativeHeader("accessToken");
//		String refreshToken = accessor.getFirstNativeHeader("refreshToken");
		
		if(accessToken == null) { //비회원이 채팅을 보냈으면
			return; 
		}
		//토큰 해석
		MemberClaimVO claimVO = tokenService.check(tokenService.removeBearer(accessToken));
		
		WebSocketRequestVO request = message.getPayload();//메세지 수신
		// 무언가 추가 작업을 수행
		WebSocketResponseVO response = new WebSocketResponseVO();
		response.setContent(request.getContent());
		response.setTime(LocalDateTime.now());
		response.setMemberId(claimVO.getMemberId());
		response.setMemberLevel(claimVO.getMemberLevel());

		//수동으로 직접 전송
//		messagingTemplate.convertAndSend("채널", 데이터);
		messagingTemplate.convertAndSend("/public/chat", response);
	}
	
}

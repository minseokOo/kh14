package com.spring12.restapi.webSocket;

import java.time.LocalDateTime;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.spring12.restapi.vo.WebSocketRequestVO;
import com.spring12.restapi.vo.WebSocketResponseVO;

/**
 	웹소켓 요청을 처리하기 위한 컨트롤러
 	- SockJS와 STOMP를 사용하면 웹소켓을 HTTP처럼 관리 할 수 있다.
 	- @Controller 를 이용하여 메세지를 매핑하고 채널에 전송 할 수 있다.
 */

@Controller
public class WebSocketController {

	// [1] /app/chat 이라는 채널로 메세지가 들어오면 /public/chat 으로 전송한다.
	@MessageMapping("/chat")//사용자가 /app/chat으로 메세지를 보내면~
	@SendTo("/public/chat")//그 메세지를 /public/chat으로 보내세요.
	public WebSocketResponseVO chat(WebSocketRequestVO message) {
		// 무언가 추가 작업을 수행
		WebSocketResponseVO response = new WebSocketResponseVO();
		response.setContent(null);
		response.setTime(LocalDateTime.now());
		return response;
		
	}
	
}

package com.spring12.restapi.webSocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
	웹소켓 설정 파일
	- FE가 웹소켓을 이용해서 서버에 접속할 수 있는 환경을 제공하는 것이 목표
 	- FE가 접속할 수 있는 주소를 설정
 	- STOMP 방식의 구조가 작동할 수 있도록 메세지 브로커를 활성화 (=도우미)
 **/

@Configuration//설정 파일로 등록
@EnableWebSocketMessageBroker//웹소켓 메세지 브로커 활성화 설정
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer{

	// [1] 사용자가 접속하거나 메세지를 보낼 수 있는 "채널"을 설정
	// - 구독(subscribe)을 통해 특정 채널의 메세지를 수신할 수 있다
	// - 게시(publish)를 통해 특정 채널에 메세지를 전달할 수 있다(구독 채널과 다름)
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		//구독 가능한 채널들을 설정
		registry.enableSimpleBroker("/public");
		//메세지를 전송할 수 있는 목적지의 접두사(Prifixes) 설정
		registry.setApplicationDestinationPrefixes("/app");
		
	}
	
	// [2] 웹소켓 연결에 대한 설정
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws")//웹소켓 연결을 위한 주소 설정
						.setAllowedOriginPatterns("*")//웹소켓용 CORS 설정(@CrossOrigin)
						.withSockJS();//SockJS는 구형 브라우저에서도 작동하도록 웹소켓을 확장한 기술
	}
	
	
}

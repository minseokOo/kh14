package com.spring12.restapi.webSocket;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

import com.spring12.restapi.service.TokenService;
import com.spring12.restapi.vo.MemberClaimVO;

import lombok.extern.slf4j.Slf4j;

/**
 * 웹소켓에 대한 사용자의 접속 및 종료를 감지하는 이벤트 처리도구
 */
@Slf4j
@Service
public class WebSocketEventHandler {

	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
//	private Map<String, String> userList = new HashMap<>();//non thread-safe(다중 접속 환경에서 위험함)
//	private Map<String, String> userList = new ConcurrentHashMap<>(); //thread-safe
	private Map<String, String> userList = Collections.synchronizedMap(new HashMap<>());
	@EventListener // implements ApplicationListener<SessionConnectEvent> 효과
	public void whenUserEnter(SessionConnectEvent event) {
		// 헤더 정보를 추출
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage()); // 분석
		String sessionId = accessor.getSessionId();
		String accessToken = accessor.getFirstNativeHeader("accessToken");
		if (accessToken == null)
			return;
		MemberClaimVO claimVO = tokenService.check(tokenService.removeBearer(accessToken));

		//저장소에 사용자 등록
		userList.put(sessionId, claimVO.getMemberId());
		log.info("사용자 접속 인원수 = {} , 세션 = {} , 아이디 = {}", userList.size(), sessionId, claimVO.getMemberId());
		
		
		
	}
	
	@EventListener
	public void whenUserSubscribe(SessionSubscribeEvent event) {
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
		if("/public/users".equals(accessor.getDestination())) {
			//채널 /users에 전파
			Set<String> values = new TreeSet<>(userList.values());
			messagingTemplate.convertAndSend("/public/users", values);
		}
	}
	
	
	@EventListener
	public void whenUserLeave(SessionDisconnectEvent event) {
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage()); // 분석
		String sessionId = accessor.getSessionId();
		
		//저장소에서 사용자 제거
		userList.remove(sessionId);
		log.info("사용자 접속종료 = {}", sessionId);
	}
}

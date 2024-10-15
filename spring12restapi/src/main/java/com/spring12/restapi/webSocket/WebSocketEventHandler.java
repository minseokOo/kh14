package com.spring12.restapi.webSocket;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;

import com.spring12.restapi.dao.WebsocketMessageDao;
import com.spring12.restapi.dto.WebsocketMessageDto;
import com.spring12.restapi.service.TokenService;
import com.spring12.restapi.vo.MemberClaimVO;
import com.spring12.restapi.vo.WebSocketDMResponseVO;
import com.spring12.restapi.vo.WebSocketResponseVO;
import com.spring12.restapi.vo.WebsocketMessageVO;

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
	
	@Autowired
	private WebsocketMessageDao websocketMessageDao;
	
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
		else if(accessor.getDestination().startsWith("/public/db")) {
			String memberId = accessor.getDestination().substring("/public/db/".length());
			//DB 조회 - 이 회원이 볼 수 있는 메세지를 100개 조회하여 전송
//			List<WebsocketMessageDto> messageList = websocketMessageDao.selectListMember(memberId, 1, 100);
//			List<Object> convertList = messageList.stream().map(messageDto->{
//				if(messageDto.getWebsocketMessageType().equals("dm")) {
//					WebSocketDMResponseVO response = new WebSocketDMResponseVO();
//					response.setSenderMemberId(messageDto.getWebsocketMessageSender());
//					response.setReceiverMemberId(messageDto.getWebsocketMessageReceiver());
//					response.setContent(messageDto.getWebsocketMessageContent());
//					response.setTime(messageDto.getWebsocketMessageTime().toLocalDateTime());
//					return response;
//				}
//				//일반
//				WebSocketResponseVO response = new WebSocketResponseVO();
//				response.setSenderMemberId(messageDto.getWebsocketMessageSender());
//				response.setContent(messageDto.getWebsocketMessageContent());
//				response.setTime(messageDto.getWebsocketMessageTime().toLocalDateTime());
//				return response;
//			})
//			.collect(Collectors.toList());
//			messagingTemplate.convertAndSend("/public/db/"+memberId, convertList);
			
			List<WebsocketMessageVO> messageList = websocketMessageDao.selectListMemberComplete(memberId, 1, 10);
			messagingTemplate.convertAndSend("/public/db/"+memberId, messageList);
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

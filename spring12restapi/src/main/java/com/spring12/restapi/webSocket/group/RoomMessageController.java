package com.spring12.restapi.webSocket.group;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.spring12.restapi.dao.RoomMessageDao;
import com.spring12.restapi.dto.RoomMessageDto;
import com.spring12.restapi.service.TokenService;
import com.spring12.restapi.vo.MemberClaimVO;
import com.spring12.restapi.vo.WebSocketRequestVO;
import com.spring12.restapi.vo.WebSocketResponseVO;

@Controller
public class RoomMessageController {

	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	@Autowired
	private TokenService tokenService;
	@Autowired
	private RoomMessageDao roomMessageDao;
	@Autowired
	private RoomDao roomDao;
	
	@MessageMapping("/room/{roomNo}")
	public void chat(@DestinationVariable int roomNo, Message<WebSocketRequestVO> message) {
		//토큰 검사 및 해석
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
		String accessToken = accessor.getFirstNativeHeader("accessToken");
		if(accessToken == null) return;
		
		MemberClaimVO claimVO = tokenService.check(tokenService.removeBearer(accessToken));
		
		//검사 추가(선택적 사용)
		RoomMemberDto roomMemberDto = new RoomMemberDto();
		roomMemberDto.setMemberId(claimVO.getMemberId());
		roomMemberDto.setRoomNo(roomNo);
		boolean canEnter = roomDao.check(roomMemberDto);
		
		WebSocketRequestVO request = message.getPayload(); //메세지 추출
		
		//메세지 발송
		WebSocketResponseVO response = new WebSocketResponseVO();
		response.setSenderMemberId(claimVO.getMemberId());
		response.setSenderMemberLevel(claimVO.getMemberLevel());
		response.setTime(LocalDateTime.now());
		response.setContent(request.getContent());
		messagingTemplate.convertAndSend("/private/room/"+roomNo, response);
		
		//DB 저장
		int roomMessageNo = roomMessageDao.sequence();
		RoomMessageDto roomMessageDto = new RoomMessageDto();
		roomMessageDto.setRoomMessageNo(roomMessageNo);
		roomMessageDto.setRoomMessageType("chat");
		roomMessageDto.setRoomMessageSender(claimVO.getMemberId());
		roomMessageDto.setRoomMessageReceiver(null);
		roomMessageDto.setRoomMessageContent(request.getContent());
		roomMessageDto.setRoomMessageTime(Timestamp.valueOf(response.getTime()));
		roomMessageDto.setRoomNo(roomNo);
		roomMessageDao.insert(roomMessageDto);
	}
}

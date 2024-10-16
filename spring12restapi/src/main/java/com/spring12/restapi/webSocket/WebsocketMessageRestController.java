package com.spring12.restapi.webSocket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring12.restapi.dao.WebsocketMessageDao;
import com.spring12.restapi.error.TargetNotFoundException;
import com.spring12.restapi.service.TokenService;
import com.spring12.restapi.vo.MemberClaimVO;
import com.spring12.restapi.vo.WebsocketMessageMoreVO;
import com.spring12.restapi.vo.WebsocketMessageVO;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/message")
public class WebsocketMessageRestController {

	@Autowired
	private WebsocketMessageDao websocketMessageDao;
	@Autowired
	private TokenService tokenService;
	
	@GetMapping("/more/{firstMessageNo}")
	public WebsocketMessageMoreVO more(@PathVariable int firstMessageNo, 
					@RequestHeader(required = false, value = "Authorization") String token){
		
		String memberId = null;//초기에 비회원으로 설정하고
		if(token != null) {// 토큰이 있을시 바꾼다.
			MemberClaimVO claimVO = tokenService.check(tokenService.removeBearer(token));
			memberId = claimVO.getMemberId();
		}
		
		
		List<WebsocketMessageVO> messageList = 
				websocketMessageDao.selectListMemberComplete
					(memberId, 1, 100, firstMessageNo);

		//반환값 생성
				WebsocketMessageMoreVO moreVO = new WebsocketMessageMoreVO();
				moreVO.setMessageList(messageList);
				moreVO.setLast(true);
				
				//남은 목록이 더 있는지 확인
				if(messageList.size() > 0) {
					List<WebsocketMessageVO> prevMessageList = 
							websocketMessageDao.selectListMemberComplete(
								memberId, 1, 100, messageList.get(0).getNo());
					moreVO.setLast(prevMessageList.isEmpty());
				}
		
		return moreVO;
	}
}

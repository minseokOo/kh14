package com.spring12.restapi.webSocket.group;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring12.restapi.error.TargetNotFoundException;
import com.spring12.restapi.service.TokenService;
import com.spring12.restapi.vo.MemberClaimVO;

@CrossOrigin
@RestController
@RequestMapping("/room")
public class RoomRestController {
	
	@Autowired
	private RoomDao roomDao;
	@Autowired
	private TokenService tokenService;
	
	
	@PostMapping("/")
	public RoomDto insert(@RequestBody RoomDto roomDto) {
		int roomNo = roomDao.sequence();
		roomDto.setRoomNo(roomNo);
		roomDao.insert(roomDto);
//		return roomDto; //DB에서 만든 정보가 들어있지 않음(시간이 안들어있음)
		return roomDao.selectOne(roomNo); //DB에서 만든 정보까지 포함해서 반환
	}
	
	@GetMapping("/")
	public List<RoomVO> list(@RequestHeader("Authorization") String token){
		MemberClaimVO claimVO = tokenService.check(tokenService.removeBearer(token));
		return roomDao.selectList(claimVO.getMemberId());
	}
	
	@DeleteMapping("/{roomNo}")
	public void delete(@PathVariable int roomNo) {
		roomDao.delete(roomNo);
	}
	
	@PostMapping("/enter")
	public void enter(@RequestBody RoomMemberDto roomMemberDto, @RequestHeader("Authorization") String token) {
		
		//방이 없는 경우를 사전 차단
		RoomDto roomDto = roomDao.selectOne(roomMemberDto.getRoomNo());
		if(roomDto == null) throw new TargetNotFoundException("존재하지 않는 방");
		
		MemberClaimVO claimVO = tokenService.check(tokenService.removeBearer(token));
		
		roomMemberDto.setMemberId(claimVO.getMemberId());//아이디 설정
//		System.out.println(roomMemberDto.getMemberId());
		System.out.println(roomMemberDto);
		roomDao.enter(roomMemberDto);//등록
	}
	
	@PostMapping("/leave")
	public void leave(@RequestBody RoomMemberDto roomMemberDto, @RequestHeader("Authorization") String token) {
		//방이 없는 경우를 사전 차단
				RoomDto roomDto = roomDao.selectOne(roomMemberDto.getRoomNo());
				if(roomDto == null) throw new TargetNotFoundException("존재하지 않는 방");
				
				MemberClaimVO claimVO = tokenService.check(tokenService.removeBearer(token));
				
				roomMemberDto.setMemberId(claimVO.getMemberId());//아이디 설정
				roomDao.leave(roomMemberDto);//등록
	}
	
}

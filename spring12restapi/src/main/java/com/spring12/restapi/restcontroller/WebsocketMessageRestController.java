package com.spring12.restapi.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring12.restapi.dao.WebsocketMessageDao;
import com.spring12.restapi.vo.WebsocketMessageVO;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/message")
public class WebsocketMessageRestController {

	@Autowired
	private WebsocketMessageDao websocketMessageDao;
	
	@PostMapping("more/{firstMessageNo}")
	public List<WebsocketMessageVO> pagingList(@PathVariable int firstMessageNo){
		List<WebsocketMessageVO> list = websocketMessageDao.selectListMemberComplete(null, firstMessageNo, firstMessageNo);
		return list;
	}
}

package com.kh.spring06.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring06.dao.PoketmonDao;
import com.kh.spring06.dto.PoketmonDto;
import com.kh.spring06.vo.StatusVO;

@CrossOrigin(origins = {"http://127.0.0.1:5500"})
@RestController
@RequestMapping("/rest/poketmon")
public class PoketmonRestController {
	@Autowired
	private PoketmonDao poketmonDao;
	
	@PostMapping("/checkPoketmonName")
	public boolean checkPoketmonName(@RequestParam String poketmonName) {
		PoketmonDto poketmonDto = poketmonDao.selectOneByName(poketmonName);
		return poketmonDto == null;
	}
	
	@PostMapping("/status")
	public List<StatusVO> status(){
		return poketmonDao.status();
	}
}

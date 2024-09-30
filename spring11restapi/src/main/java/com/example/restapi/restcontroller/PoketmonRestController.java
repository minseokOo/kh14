package com.example.restapi.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.dao.PoketmonDao;
import com.example.restapi.dto.PoketmonDto;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/poketmon")
public class PoketmonRestController {
	
	@Autowired
	private PoketmonDao poketmonDao;
	
	// 목록(R) - GetMapping
	// 상세(R) - GetMapping
	// 삭제(D) - DeleteMapping
	// 등록(C) - PostMapping
	// 수정(U) - PutMapping (PatchMapping)
	
	//(구)http://localhost:8080/poketmon/list
	//(신)http://localhost:8080/poketmon/ [GET]
	@GetMapping("/")
	public List<PoketmonDto> list(){
		return poketmonDao.selectList();
	}
	
	//(구)http://localhost:8080/poketmon/list?column=poketmon_name&keyword=OOO
	//(신)http://localhost:8080/poketmon/column/poketmon_name/keyword/OOO
	@GetMapping("/column/{column}/keyword/{keyword}")
	public List<PoketmonDto> search(
			@PathVariable String column, @PathVariable String keyword){
		return poketmonDao.selectList(column, keyword);
	}
	
	//(구) http://localhost:8080/poketmon/detail?poketmonNo=1
	//(신) http://localhost:8080/poketmon/1 [GET]
	@GetMapping("/{poketmonNo}") 
	public PoketmonDto detail(@PathVariable int poketmonNo) {
		return poketmonDao.selectOne(poketmonNo);
	}
	
	//(구) http://localhost:8080/poketmon/delete?poketmonNo=1
	//(신) http://localhost:8080/poketmon/1 [DELETE}
	@DeleteMapping("/{poketmonNo}")
	public void delete(@PathVariable int poketmonNo) {
		poketmonDao.delete(poketmonNo);
	}
	
	//(구) http://localhost:8080/poketmon/insert
	//(신) http://localhost:8080/poketmon/ [POST]
	
	@PostMapping("/")
	//public void insert(@ModelAttribute PoketmonDto poketmonDto) { //form data일 경우만 가능
	public void insert(@RequestBody PoketmonDto poketmonDto) { //가능 (JSON 방식 수신가능)
		poketmonDao.insert(poketmonDto);
	}
	
	// (구) http://localhost:8080/poketmon/update
	// (신) http://localhost:8080/poketmon/ [PUT]
	@PutMapping("/")
	public void update(@RequestBody PoketmonDto poketmonDto) {
		poketmonDao.update(poketmonDto);
	}
	
	
}

package com.spring12.restapi.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring12.restapi.dao.EmpDao;
import com.spring12.restapi.dto.EmpDto;
import com.spring12.restapi.error.TargetNotFoundException;

@CrossOrigin(origins= {"http://localhost:3000"})
@RestController
@RequestMapping("/emp")
public class EmpRestController {

	@Autowired
	private EmpDao empDao;
	
	@GetMapping("/")
	public List<EmpDto> list(){
		return empDao.selectList();
	}
	
	@GetMapping("/column/{column}/keywore/{keyword}")
	public List<EmpDto> search(
			@PathVariable String column, 
			@PathVariable String keyword){
		List<EmpDto> list = empDao.selectList(column, keyword);
		return list;
	}
	
	@GetMapping("/{empNo}")
	public EmpDto detail(@PathVariable int empNo) {
		EmpDto empDto = empDao.selectOne(empNo);
		if(empDto == null)
			throw new TargetNotFoundException();
		return empDto;
	}
	
	@DeleteMapping("/{empNo}")
	public void delete(@PathVariable int empNo) {
		boolean result = empDao.remove(empNo);
		if(result == false) { //삭제하지 못했다면 200이 아니라 404로 처리
			throw new TargetNotFoundException();
		}
	}
	
	@PostMapping("/")
	public void insert(@RequestBody EmpDto empDto) {
		empDao.insert(empDto);
	}
	
	@PutMapping("/")
	public void update(@RequestBody EmpDto empDto) {
		boolean result = empDao.edit(empDto);
		if(result == false) {
			throw new TargetNotFoundException();
		}
	}
	
}

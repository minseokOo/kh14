package com.kh.spring06.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring06.dao.BookDao;
import com.kh.spring06.vo.StatusVO;

@CrossOrigin(origins = {"http://127.0.0.1:5500"})
@RestController
@RequestMapping("/rest/book")
public class BookRestController {
	@Autowired
	private BookDao bookDao;
	
	@PostMapping("/status")
	public List<StatusVO> status(){
		return bookDao.selectListByGanre();
	}

}

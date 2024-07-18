package com.kh.spring07.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	
	@RequestMapping("/")
	public String home() {
		return "/WEB-INF/views/home.jsp";
		
	}
	
	//GET 방식으로는 파일의 이름만 전송된다.
	// - 주소는 길이제한이 존재
	// - key=value 형태로 데이터를 한 개만 보낼 수 있기 때문
	@GetMapping("/upload1")
	public String upload1(
			@RequestParam String poketmonName, 
			@RequestParam String poketmonType, 
			@RequestParam String attach
			) {
		System.out.println("poketmonName = " + poketmonName);
		System.out.println("poketmonType = " + poketmonType);
		System.out.println("attach = " + attach);
		return "redirect:/";
	}
	
	@PostMapping("/upload2")
	public String upload2(
			@RequestParam String poketmonName, 
			@RequestParam String poketmonType, 
			@RequestParam String attach
			) {
		System.out.println("poketmonName = " + poketmonName);
		System.out.println("poketmonType = " + poketmonType);
		System.out.println("attach = " + attach);
		return "redirect:/";
	}
	
	//multipart/form-data 를 처리하는 컨트롤러
	//multipart 일 경우 MultipartRequest 또는 MultipartFile 등을 사용할 수 있다.
	@PostMapping("/upload3")
	public String upload3(
			@RequestParam String poketmonName, 
			@RequestParam String poketmonType, 
			@RequestParam MultipartFile attach) throws IllegalStateException, IOException {
		System.out.println("poketmonName = " + poketmonName);
		System.out.println("poketmonType = " + poketmonType);
//		System.out.println("attach = " + attach);
		System.out.println("파일명 = " + attach.getOriginalFilename());
		System.out.println("파일유형 = " + attach.getContentType());
		System.out.println("파일크기 = " + attach.getSize());
		
		//파일을 실제 저장소(HDD)에 저장
		File dir = new File("D:/upload");
		dir.mkdirs();
		System.out.println("업로드 위치 = " + dir.getAbsolutePath());
		
		File target = new File(dir, attach.getOriginalFilename());//저장할 파일을 정하고
		attach.transferTo(target);//저장
		
		return "redirect:/";
	}
	
}

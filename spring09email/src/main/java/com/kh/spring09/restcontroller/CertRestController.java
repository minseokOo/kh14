package com.kh.spring09.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring09.dao.CertDao;
import com.kh.spring09.dto.CertDto;
import com.kh.spring09.service.EmailService;

@CrossOrigin(origins = {"http://127.0.0.1:5500"})
@RestController
@RequestMapping("/rest/cert")
public class CertRestController {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private CertDao certDao;
	
	//사용자가 요구하는 이메일로 인증메일을 발송하는 기능
	@PostMapping("/send")
	public void send(@RequestParam String certEmail){
		emailService.sendCert(certEmail);
	}
	//사용자가 입력한 인증번호가 유효한지를 판정하는 기능
	@PostMapping("/check")
	public boolean check(@ModelAttribute CertDto certDto) {
		boolean result =  certDao.check(certDto, 5);
		if(result) {
			certDao.delete(certDto.getCertEmail());
		}
		return result;
	}
}

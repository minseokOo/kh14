package com.kh.spring10.service;

import org.springframework.stereotype.Service;

@Service
public class PaddingEncryptService {
	
	//암호화
	public String encode(String rawStr, String padding) {
		StringBuffer buffer = new StringBuffer();
		for(int i=0; i<rawStr.length(); i++) {
			char ch = rawStr.charAt(i);
			buffer.append(ch);
			buffer.append(padding);
		}
		return buffer.toString();
	}
	
	//복호화
	public String decode(String encStr) {
		StringBuffer buffer = new StringBuffer();
		for(int i=0; i<encStr.length(); i+=2) {
			char ch = encStr.charAt(i);
			buffer.append(ch);
		}
		return buffer.toString(); //복호화 결과를 반환
	}
}

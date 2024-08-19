package com.kh.spring06.service;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class RandomService {
private Random r = new Random();
	
	public String generateNumber(int size) {
		StringBuffer buffer = new StringBuffer();
		
		for(int i=0; i<size; i++) {
		int number = r.nextInt(10);
		buffer.append(number);
		}
		return buffer.toString();
	}
	
	private List<String> upper = List.of(
		"A","B","C","D","E","F","G","H","I","J","K","l","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"	
	);
	private List<String> lower =List.of( "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z");
	
	private List<String> number = List.of("1","2","3","4","5","6","7","8","9","0");
	private List<String> special = List.of("!","@","#","$");
	
	
	public String generateString(int size) {
		StringBuffer buffer = new StringBuffer();
		if(size<4) {//4글자 미만이면 알파벳 소문자만
			for(int i = 0; i<size; i++) {//size에 들어온 숫자만큼 반복하며
				int index = r.nextInt(lower.size());//랜덤 위치 선정
				buffer.append(lower.get(index));//추첨된 위치에 해당하는 글자를 추가
			}
		}
		else {//4글자 이상이면 대문자,숫자,특수문자 1개씩 + 알파벳 소문자
			buffer.append(upper.get(r.nextInt(upper.size())));//대문자 1개
			for(int i=0; i<size-3; i++) {
			buffer.append(lower.get(r.nextInt(lower.size())));//소문자 1개
			}
			buffer.append(number.get(r.nextInt(number.size())));//숫자 1개
			buffer.append(special.get(r.nextInt(special.size())));//특수문자 1개
		}
		for(int i=0; i<size; i++) {
			
		}
		return buffer.toString();
	}
}

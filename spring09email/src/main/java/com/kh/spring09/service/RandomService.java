package com.kh.spring09.service;

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
}

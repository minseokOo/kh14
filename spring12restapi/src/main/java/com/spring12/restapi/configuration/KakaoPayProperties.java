package com.spring12.restapi.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
@ConfigurationProperties(prefix = "custom.kakaopay")
public class KakaoPayProperties {
	private String secret;
	private String cid;
	
}

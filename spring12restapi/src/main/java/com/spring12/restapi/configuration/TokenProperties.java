package com.spring12.restapi.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
@ConfigurationProperties(prefix = "custom.token")
public class TokenProperties {
	private String secret;
	private int expire;
	private String issuer;
}
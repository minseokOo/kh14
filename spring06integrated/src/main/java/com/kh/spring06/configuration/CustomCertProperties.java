package com.kh.spring06.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
	@Service
	@ConfigurationProperties(prefix = "custom.cert")
	public class CustomCertProperties {
		private int expire;
}

package com.kh.spring06.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
@ConfigurationProperties(prefix = "custom.email")
public class CustomEmailProperties {
	private String host;
	private int port;
	private String username;
	private String password;
}

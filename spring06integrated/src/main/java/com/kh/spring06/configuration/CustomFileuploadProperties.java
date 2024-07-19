package com.kh.spring06.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import lombok.Data;

//custo.fileupload로 만들어진 속성들을 불러오기 위한 파일
@Data
@Service
@ConfigurationProperties(prefix = "custom.fileupload")
public class CustomFileuploadProperties {
	private String path;
}

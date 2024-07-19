package com.kh.spring06.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.catalina.connector.Response;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring06.configuration.CustomFileuploadProperties;
import com.kh.spring06.dao.AttachmentDao;
import com.kh.spring06.dto.AttachmentDto;
import com.kh.spring06.error.TargetNotFoundException;

import jakarta.annotation.PostConstruct;

//첨부파일 서비스
@Service
public class AttachmentService {

	
	// 목표 : application.properties에 작성된 설정을 불러와 업로드 폴더로 지정
	@Autowired
	private CustomFileuploadProperties properties;
	private File dir;
	@PostConstruct //객체 생성 및 등록 후 딱 한번만 실행되는 메소드(초기세팅)
	public void init() {
		dir = new File(properties.getPath());
		dir.mkdirs();
	}
	
	
	@Autowired
	private AttachmentDao attachmentDao;
	
	
	public int save(MultipartFile attach) throws IllegalStateException, IOException {
		int attachmentNo = attachmentDao.sequence();
		// 2-2. 실물 파일 저장
		File target = new File(dir, String.valueOf(attachmentNo));
		attach.transferTo(target);
		
		// 2-3. DB저장
		AttachmentDto attachmentDto = new AttachmentDto();
		attachmentDto.setAttachmentNo(attachmentNo);
		attachmentDto.setAttachmentName(attach.getOriginalFilename());
		attachmentDto.setAttachmentType(attach.getContentType());
		attachmentDto.setAttachmentSize(attach.getSize());
		attachmentDao.insert(attachmentDto);
		
		return attachmentNo;

	}
	
	public void delete(int attachmentNo) {//파일삭제 + DB삭제
		//파일삭제
		AttachmentDto attachmentDto = attachmentDao.selectOne(attachmentNo);
		if(attachmentDto == null) {
			throw new TargetNotFoundException("존재하지 않는 파일 번호");
		}

		//실물 파일 삭제
		
		File target = new File(dir, String.valueOf(attachmentNo));
		target.delete();

		//DB삭제
		attachmentDao.delete(attachmentNo);
	}
	
	public ResponseEntity<ByteArrayResource> find(int attachmentNo) throws IOException{
		
	// (1) attachmentNo에 대한 데이터가 존재하는지 확인해야 한다.
	AttachmentDto attachmentDto = attachmentDao.selectOne(attachmentNo);
	if(attachmentDto == null) {
		throw new TargetNotFoundException("존재하지 않는 파일 번호");
	}
	
	// (2) 정보가 있으므로 실제 파일을 불러온다.
	// - 파일을 한 번에 쉽게 불러주는 라이브러리 사용 (apache commons io)
	File target = new File(dir, String.valueOf(attachmentNo));
	byte[] data = FileUtils.readFileToByteArray(target);
	ByteArrayResource resource = new ByteArrayResource(data); //포장
	
	// (3) 불러온 정보를 사용자에게 전송(헤더 + 바디)
//	return ResponseEntity.ok().body(데이터);
	return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.contentLength(attachmentDto.getAttachmentSize())
				.header(HttpHeaders.CONTENT_ENCODING	, StandardCharsets.UTF_8.name())
				.header(HttpHeaders.CONTENT_DISPOSITION, 
						ContentDisposition.attachment().filename(attachmentDto.getAttachmentName(), 
																								StandardCharsets.UTF_8).build().toString())
			.body(resource);
	}
}

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

import com.kh.spring06.dao.AttachmentDao;
import com.kh.spring06.dto.AttachmentDto;
import com.kh.spring06.error.TargetNotFoundException;

//첨부파일 서비스
@Service
public class AttachmentService {
	
	@Autowired
	private AttachmentDao attachmentDao;
	
	private File dir = new File("D:/upload");
	
	public int save(MultipartFile attach) throws IllegalStateException, IOException {
		int attachmentNo = attachmentDao.sequence();
		// 2-2. 실물 파일 저장
		dir.mkdirs();
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

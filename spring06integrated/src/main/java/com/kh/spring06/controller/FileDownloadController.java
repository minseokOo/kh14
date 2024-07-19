package com.kh.spring06.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring06.dao.AttachmentDao;
import com.kh.spring06.service.AttachmentService;

// 사용자에게 파일을 전송하는 컨트롤러
//이 컨트롤러는 화면이 아니라 데이터를 사용자에게 보냅니다.
@RestController 
@RequestMapping("/attach")
public class FileDownloadController {
	
	@Autowired
	private AttachmentDao attachmentDao;
	
	@Autowired
	private AttachmentService attachmentService;
	
	@RequestMapping("/download")
	public ResponseEntity<ByteArrayResource> download(@RequestParam int attachmentNo) throws IOException{
	return attachmentService.find(attachmentNo);
	}
	// 1. 직접 스프링을 거치지 않고 사용자에게 파일을 전송하는 방법
	// - HttpServletResponse는 사용자에게 보낼 정보를 담는 객체
//	@RequestMapping("/download")
////	public void download(@RequestParam int attachmentNo, 
//												HttpServletResponse response) throws IOException {
//		// (1) attachmentNo에 대한 데이터가 존재하는지 확인해야 한다.
//		AttachmentDto attachmentDto = attachmentDao.selectOne(attachmentNo);
//		if(attachmentDto == null) {
//			throw new TargetNotFoundException("존재하지 않는 파일 번호");
//		}
//		
//		// (2) 정보가 있으므로 실제 파일을 불러온다.
//		// - 파일을 한 번에 쉽게 불러주는 라이브러리 사용 (apache commons io)
//		File dir = new File("D:/upload");
//		File target = new File(dir, String.valueOf(attachmentNo));
//		byte[] data = FileUtils.readFileToByteArray(target);
//		
//		// (3) 불러온 정보를 사용자에게 전송(헤더 + 바디)
////		헤더 설정 명령 - response.setHeader("이름", "값");
////		바디 설정 명령 - response.getOutputStream().write(데이터);
//		response.setHeader("Content-Encoding", "UTF-8");
//		response.setHeader("Content-Type", "application/octet-stream");
////		response.setHeader("Content-Type", attachmentDto.getAttachmentType());
//		response.setHeader("Content-Length", String.valueOf(data.length));
//		response.setHeader("Content-Disposition", 
//				"attachment; filename=\"" + attachmentDto.getAttachmentName()+"\"");
//		
//		response.getOutputStream().write(data);
//		
//	}
//	
//	// 2. 스프링에게 다운로드 가능한 상태로 데이터(Response Entity)를 전달하는 방법 (추천)
//	//@RequestMapping("/download")
//	public ResponseEntity<ByteArrayResource> download(
//																		@RequestParam int attachmentNo) throws IOException{
//		// (1) attachmentNo에 대한 데이터가 존재하는지 확인해야 한다.
//				AttachmentDto attachmentDto = attachmentDao.selectOne(attachmentNo);
//				if(attachmentDto == null) {
//					throw new TargetNotFoundException("존재하지 않는 파일 번호");
//				}
//				
//				// (2) 정보가 있으므로 실제 파일을 불러온다.
//				// - 파일을 한 번에 쉽게 불러주는 라이브러리 사용 (apache commons io)
//				File dir = new File("D:/upload");
//				File target = new File(dir, String.valueOf(attachmentNo));
//				byte[] data = FileUtils.readFileToByteArray(target);
//				ByteArrayResource resource = new ByteArrayResource(data); //포장
//				
//				// (3) 불러온 정보를 사용자에게 전송(헤더 + 바디)
////				return ResponseEntity.ok().body(데이터);
//				return ResponseEntity.ok()
//							.contentType(MediaType.APPLICATION_OCTET_STREAM)
//							.contentLength(attachmentDto.getAttachmentSize())
//							.header(HttpHeaders.CONTENT_ENCODING	, StandardCharsets.UTF_8.name())
//							.header(HttpHeaders.CONTENT_DISPOSITION, 
//									ContentDisposition.attachment().filename(attachmentDto.getAttachmentName(), 
//																											StandardCharsets.UTF_8).build().toString())
//						.body(resource);
//				
//	}
}

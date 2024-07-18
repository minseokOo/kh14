package com.kh.spring06.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring06.dao.AttachmentDao;
import com.kh.spring06.dao.PoketmonDao;
import com.kh.spring06.dto.AttachmentDto;
import com.kh.spring06.dto.PoketmonDto;

@Controller
@RequestMapping("/poketmon")
public class PoketmonController {
	
	@Autowired
	private PoketmonDao poketmonDao;
	
	@Autowired
	private AttachmentDao attachmentDao;
	
	
	
//	@RequestMapping("/insert1")//입력
	@GetMapping("/insert")//GET방식만 처리
	public String insert() {
		return "/WEB-INF/views/poketmon/insert1.jsp";
	}
	
////	@RequestMapping("/insert2")//처리
//	@PostMapping("/insert")//POST방식만 처리
//	public String insert(@ModelAttribute PoketmonDto dto) {
//		dao.insert(dto);
//		return "redirect:insertComplete"; //리다이렉트(상대경로)
//	}
//	
	//이 메소드는 하나의 트랜잭션(세트메뉴)으로 취급됨
	//Database의 C.U.D 작업을 여러 번 하는 경우 전체를 하나로 생각하여 처리
	//다 되거나, 다 안되거나 둘 중 하나밖에 없음
	@Transactional 
	@PostMapping("/insert")//POST방식만 처리
	public String insert(@ModelAttribute PoketmonDto poketmonDto, 
			@RequestParam MultipartFile attach) throws IllegalStateException, IOException {
		// 1. 포켓몬스터 번호 생성
		int poketmonNo = poketmonDao.sequence();
		poketmonDto.setPoketmonNo(poketmonNo);
		
		// 2. 포켓몬스터 등록
		poketmonDao.insertWithSequence(poketmonDto);
		
		//MultipartFile은 비어있을 수 있으므로 조건으로 검사를 해야한다.
		if(!attach.isEmpty()) {
			
			int attachmentNo = attachmentDao.sequence();
		// 3. 첨부파일 저장(있으면) - 이름이 겹치지 않도록 시퀀스로 이름 설정
			File dir = new File("D:/upload");
			dir.mkdirs();
			
//			File target = new File(dir, attach.getOriginalFilename());
			File target = new File(dir, String.valueOf(attachmentNo));
			attach.transferTo(target);
			
		// 4. 첨부파일 정보 등록(attachment)
			AttachmentDto attachmentDto = new AttachmentDto();
			attachmentDto.setAttachmentNo(attachmentNo);
			attachmentDto.setAttachmentName(attach.getOriginalFilename());
			attachmentDto.setAttachmentType(attach.getContentType());
			attachmentDto.setAttachmentSize(attach.getSize());
			attachmentDao.insert(attachmentDto);
		// 5. 첨부파일이 있다면 포켓몬스터와 첨부파일을 연결(poketmon_image table)
		// insert into poketmon_image(poketmon, attachment) values(?, ?);
			poketmonDao.connect(poketmonNo, attachmentNo);
			
		
		}
		
		return "redirect:insertComplete"; //리다이렉트(상대경로)
	}
	
	@RequestMapping("/insertComplete")//완료
	public String insertComplete() {
		return "/WEB-INF/views/poketmon/insert3.jsp";
	}
	
	//목록(검색) 페이지
	// - DB 조회한 결과를 화면에 전달한 뒤 출력 (Model 필요)
	@RequestMapping("/list")
	public String list(Model model,
			@RequestParam(required = false) String column,
			@RequestParam(required = false) String keyword) {
		boolean isSearch = column != null && keyword != null;
		
		List<PoketmonDto> list = isSearch ? 
				poketmonDao.selectList(column, keyword) : poketmonDao.selectList();
		
		model.addAttribute("column", column);// 검색분류
		model.addAttribute("keyword", keyword);// 검색어
		model.addAttribute("list", list);
		return "/WEB-INF/views/poketmon/list.jsp";
		
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam int poketmonNo, Model model) {
		PoketmonDto dto = poketmonDao.selectOne(poketmonNo);
		model.addAttribute("dto", dto);
		return "/WEB-INF/views/poketmon/detail.jsp";
	}
	
	//삭제
	@RequestMapping("/delete")
	public String delete(@RequestParam int poketmonNo) {
		boolean result = poketmonDao.delete(poketmonNo);
		return "redirect:list";
	}
	
	// 수정 (입력) - 화면에 띄울 정보를 구해서 전달해야 한다
	@GetMapping("/edit")
	public String edit(Model model, @RequestParam int poketmonNo) {
		PoketmonDto dto = poketmonDao.selectOne(poketmonNo);
		model.addAttribute("dto", dto);
		return "/WEB-INF/views/poketmon/edit.jsp";
	}
	// 수정 (처리)
	@PostMapping("/edit")
	public String edit(@ModelAttribute PoketmonDto dto) {
		boolean result = poketmonDao.update(dto);
		return "redirect:detail?poketmonNo="+dto.getPoketmonNo();
	}
}

package com.kh.spring06.controller;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring06.dao.BoardDao;
import com.kh.spring06.dto.BoardDto;
import com.kh.spring06.error.TargetNotFoundException;
import com.kh.spring06.service.AttachmentService;
import com.kh.spring06.vo.PageVO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardDao boardDao;
	
	
//	//글 목록
//	@RequestMapping("/list")
//	public String list(Model model, 
//			@RequestParam(required = false) String column,
//			@RequestParam(required = false) String keyword, 
//			@RequestParam(required = false, defaultValue= "1")  int page,
//			@RequestParam(required = false, defaultValue= "10") int size) {
//		boolean isSearch = column != null && keyword != null;
//		List<BoardDto> list = isSearch ? 
//				boardDao.selectListByPaging(column, keyword, page, size) : boardDao.selectListByPaging(page, size);
//		
//		model.addAttribute("list", list);
//		model.addAttribute("column", column);
//		model.addAttribute("keyword", keyword);
//		
//		//(추가) 페이지 네비게이터 출력을 위한 추가 정보를 계산 및 전달
//		int blockSize = 10;
//		int startBlock = (page-1) / blockSize * blockSize +1;
//		int finishBlock = startBlock + blockSize - 1;
//		model.addAttribute("startBlock", startBlock);
//		model.addAttribute("finishBlock", finishBlock);
//		
//		//(추가) 마지막 번호와 글 개수를 계산하여 전달
//		int count = isSearch ? boardDao.countByPaging(column, keyword)
//				: boardDao.countByPaging();
//		int lastBlock = (count -1) / size + 1;
//		model.addAttribute("count", count);
//		model.addAttribute("lastBlock", lastBlock);
//		return "/WEB-INF/views/board/list.jsp";
//	}
	
	//목록+ 검색 + 페이징(신버전)
	// (TIP) @ModelAttribute는 옵션을 통해 화면으로 바로 전달 가능
	@RequestMapping("/list")
	public String list(
			@ModelAttribute("pageVO") PageVO pageVO, Model model) {
		model.addAttribute("boardList", boardDao.selectListByPaging(pageVO));
		int count = boardDao.countByPaging(pageVO);
		pageVO.setCount(count);
		model.addAttribute("pageVO", pageVO);//@ModelAttribute로 대체
		return "/WEB-INF/views/board/list2.jsp";
	}
	private boolean checkSearch(String column, String keyword) {
		if(column == null) return false;
		if(keyword == null) return false;
		switch(column) {
		case "board_title":
		case "board_writer":
			return true;
		}
		return false;
	}
	
	//글 작성
	@GetMapping("/write")
	public String write() {
		return "/WEB-INF/views/board/write.jsp";
	}
	@PostMapping("/write")
	public String write(@ModelAttribute BoardDto boardDto, HttpSession session) {
		String createdUser = (String)session.getAttribute("createdUser");
		//시퀀스 번호를 먼저 생성하도록 지시
		int seq = boardDao.sequence();
		
		//(추가) 새글, 답글 여부에 따라 그룹, 상위글, 차수를 설정해야한다.
		if(boardDto.isNew()) {
			boardDto.setBoardGroup(seq);//그룹번호는 글 번호와 동일
			boardDto.setBoardTarget(null);//상위 글 번호는 null로 설정(생략 가능)
			boardDto.setBoardDepth(0);//차수는 0으로 설정(생략가능)
		}
		else {
			//타겟글의 정보 조회
			BoardDto targetDto = boardDao.selectOne(boardDto.getBoardTarget());
			boardDto.setBoardGroup(targetDto.getBoardGroup());//그룹번호는 원본 글과 동일
			boardDto.setBoardTarget(targetDto.getBoardNo());//상위 글 번호는 원본글 번호와 동일 (안써도됨)
			boardDto.setBoardDepth(targetDto.getBoardDepth()+1);//차수는 원본글보다 1크다.
		}
		
		boardDto.setBoardWriter(createdUser);
		boardDto.setBoardNo(seq);
		boardDao.write(boardDto);
		return "redirect:read?boardNo=" + seq;
	}
//	@RequestMapping("/writeFinish")
//	public String writeFinish() {
//		return "/WEB-INF/views/board/writeFinish.jsp";
//	}
	
	//읽기
	@RequestMapping("/read")
	public String read(@RequestParam int boardNo, Model model) {
//		boardDao.updateBoardViews(boardNo);
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if(boardDto == null) throw new TargetNotFoundException("존재하지 않는 글 번호");
		model.addAttribute("boardDto", boardDto);
		return "/WEB-INF/views/board/read.jsp";
	}
	
	//수정
	@GetMapping("/update")
	public String update(Model model, @RequestParam int boardNo) {
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if(boardDto == null) throw new TargetNotFoundException("존재하지 않는 글 번호");
		model.addAttribute("boardDto", boardDto);
		return "/WEB-INF/views/board/update.jsp";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute BoardDto boardDto) {
		if(boardDto == null) throw new TargetNotFoundException("존재하지 않는 글 번호");
		boardDao.update(boardDto);
		return "redirect:read?boardNo="+boardDto.getBoardNo();
	}
	
	@Autowired
	private AttachmentService attachmentService;
	//삭제
	// - 추가) 글 안에 들어가 있는 이미지 파일을 모두 찾아서 삭제한 뒤 글 삭제
	@RequestMapping("/delete")
	public String delete(@RequestParam int boardNo) {
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if(boardDto == null) throw new TargetNotFoundException("존재하지 않는 글 번호");
		
		String boardContent = boardDto.getBoardContent();//글 내용을 추출
		//boardContent에 들어있는 내용 중에 <img class="board-attach">를 찾아
		// -> Jsoup 이라는 라이브러리를 활용하면 HTML 탐색이 쉬워진다
		Document document = Jsoup.parse(boardContent); //html로 해석
		Elements elements = document.select(".board-attach"); //찾아
		for(Element element : elements) {//찾은걸 반복
			String key = element.attr("data-key"); //data-key 속성을 읽어서
			int attachmentNo = Integer.parseInt(key);//숫자로 바꿔서
			attachmentService.delete(attachmentNo);//삭제 (파일 + DB)
		}
		boolean result = boardDao.delete(boardNo);
		return "redirect:list";
	}

	
	
}


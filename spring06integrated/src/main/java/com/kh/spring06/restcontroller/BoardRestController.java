package com.kh.spring06.restcontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring06.dao.BoardDao;
import com.kh.spring06.dao.BoardLikeDao;
import com.kh.spring06.error.TargetNotFoundException;
import com.kh.spring06.service.AttachmentService;
import com.kh.spring06.vo.BoardLikeVO;

import jakarta.servlet.http.HttpSession;

//게시글에서 발생하는 비동기통신을 처리하는 컨트롤러
@CrossOrigin(origins = { "http://127.0.0.1:5500" })
@RestController
@RequestMapping("/rest/board")
public class BoardRestController {

	@Autowired
	private BoardDao boardDao;
	@Autowired
	private BoardLikeDao boardLikeDao;
	
// 어떤 회원이 게시글에 좋아요를 눌렀는지 체크하여 알려주는 매핑
	@PostMapping("/check")
	public BoardLikeVO check(HttpSession session, @RequestParam int boardNo){
		// 회원 아이디 추출
		String memberId = (String)session.getAttribute("createdUser");
		
		BoardLikeVO boardLikeVO = new BoardLikeVO();
		boardLikeVO.setChecked(boardLikeDao.check(memberId, boardNo));
		boardLikeVO.setCount(boardLikeDao.count(boardNo));
		
		return boardLikeVO;
	}
//좋아요를 하거나 또는 취소하게 만드는 기능 (비회원은 못들어옴)
	@PostMapping("/action")
	public BoardLikeVO action(HttpSession session, @RequestParam int boardNo) {
		String memberId = (String) session.getAttribute("createdUser");
		boolean isChecked = boardLikeDao.check(memberId, boardNo);
		if(isChecked) { //좋아요 이력이 있으면 삭제
			boardLikeDao.delete(memberId, boardNo);
		}
		else { //좋아요 이력이 없으면 추가
			boardLikeDao.insert(memberId, boardNo);
		}
		//좋아요 수 최신화
		boardDao.updateBoardLikes(boardNo);
		
		BoardLikeVO boardLikeVO = new BoardLikeVO();
		boardLikeVO.setChecked(!isChecked);
		boardLikeVO.setCount(boardLikeDao.count(boardNo));
		
		return boardLikeVO;
	}
	
	//글 내부에 포함될 이미지를 업로드하고 번호를 반환하는 기능
	@Autowired
	private AttachmentService attachmentService;
	
	@PostMapping("/upload")
	public int upload(@RequestParam MultipartFile attach) throws IllegalStateException, IOException {
		if(attach.isEmpty()) {
			throw new TargetNotFoundException("파일이 존재하지 않습니다.");
		}
		int attachmentNo = attachmentService.save(attach);
		return attachmentNo;
	}
	
	@PostMapping("/uploads")
	public List<Integer> uploads 
	(@RequestParam(value= "attach") List<MultipartFile> attachList) throws IllegalStateException, IOException{
		List<Integer> results = new ArrayList<>(); //번호 담을 저장소 생성
		for(MultipartFile attach : attachList) {
			if(!attach.isEmpty()) {
				int attachmentNo = attachmentService.save(attach);
				results.add(attachmentNo);
			}
		}
		return results;
	}
	
}

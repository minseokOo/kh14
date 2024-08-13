package com.kh.spring06.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring06.dao.BoardDao;
import com.kh.spring06.dao.ReplyDao;
import com.kh.spring06.dto.ReplyDto;
import com.kh.spring06.error.TargetNotFoundException;
import com.kh.spring06.vo.ReplyListVO;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/rest/reply")
public class ReplyRestController {

	@Autowired
	private ReplyDao replyDao;
	
	@Autowired
	private BoardDao boardDao;
	
	@PostMapping("/write")
	public void write(@ModelAttribute ReplyDto replyDto, HttpSession session){
		//step 1 : 시퀀스 번호를 생성한다.
		int seq = replyDao.sequence();
		
		//step 2 : 작성자 정보를 불러온다.
		String memberId = (String)session.getAttribute("createdUser");
		
		//step 3 : 정보를 설정한다.
		replyDto.setReplyNo(seq);
		replyDto.setReplyWriter(memberId);
		
		//step 4 - 등록
		replyDao.insert(replyDto);
		
		//step 5 - write가 끝나면 댓글 수 최신화
		boardDao.updateBoardReplies(replyDto.getReplyOrigin());
		
	}
	
	@RequestMapping("/list")
	public List<ReplyDto> list(@RequestParam int replyOrigin){
		return replyDao.selectList(replyOrigin);
	}
	
	//프론트엔드에게 좀 더 자세한 정보를 전달하여 원활한 더보기 표시가 가능하도록 구현
	//[1] 표시할 댓글 데이터
	//[2] 전체 페이지 수
	//[3] 현재 제공하는 페이지 번호
	@RequestMapping("/list/paging")
	public ReplyListVO listByPaging(@RequestParam int replyOrigin, 
			@RequestParam(required = false, defaultValue = "1") int page, 
			@RequestParam(required = false, defaultValue = "10") int size){
		
		int count = replyDao.count(replyOrigin);
		int totalPage = (count + size-1) / size;
		
		ReplyListVO replyListVO = new ReplyListVO();
		replyListVO.setList(replyDao.selectList(replyOrigin, page, size));
		replyListVO.setTotalPage(totalPage);
		replyListVO.setCurrentPage(page);
		return replyListVO;
	}
	
	@PostMapping("/delete")
	public void delete(HttpSession session, @RequestParam int replyNo){
		String memberId = (String)session.getAttribute("createdUser");
		ReplyDto replyDto = replyDao.selectOne(replyNo);
		if(replyDto == null) {
			throw new TargetNotFoundException();
		}
		
		boolean isOwner = memberId.equals(replyDto.getReplyWriter());
		if(isOwner) {
		replyDao.delete(replyNo);
		boardDao.updateBoardReplies(replyDto.getReplyOrigin());
		}
		
	}
	
	@PostMapping("/edit")
	public void edit(HttpSession session, @ModelAttribute ReplyDto replyDto) {
		String memberId = (String) session.getAttribute("createdUser");
		ReplyDto originDto = replyDao.selectOne(replyDto.getReplyNo());
		if(originDto == null) {
			throw new TargetNotFoundException();
		}
		boolean isOwner = memberId.equals(originDto.getReplyWriter());
		if(isOwner) {
			replyDao.update(replyDto);
		}
	}
}

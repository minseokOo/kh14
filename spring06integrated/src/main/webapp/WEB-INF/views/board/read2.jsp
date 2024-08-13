<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<!-- 댓글 스타일 -->
<style>
	.reply-wrapper{
		display:flex;
	}
	.reply-wrapper > .image-wrapper{
		width: 100px;
		padding: 10px;
		
	}
	.reply-wrapper > .image-wrapper > img {
		width: 100%;
		}
	.reply-wrapper > .content-wrapper{
		flex-grow: 1;'
		font-size: 16px;
	}
	.reply-wrapper > .content-wrapper > .reply-title{
		font-size: 1.25em;
	}
	.reply-wrapper > .content-wrapper > .reply-content{
		font-size: 0.95em;
		min-height: 50px;
	}
	.reply-wrapper > .content-wrapper > .reply-info{
		font-size: 0.7em;
		
	}
</style>

<!-- 댓글 처리를 위한 JS 코드 -->
<script type="text/javascript">
	$(function(){
		// 이 페이지의 파라미터 중에서 boardNo의 값을 알아내는 코드
		var params = new URLSearchParams(location.search);
		var boardNo = params.get("boardNo");
		
		//현재 로그인한 사용자의 아이디를 변수로 저장(안좋은 방법이지만 어쩔수 없이 사용)
		var currentUser = "${sessionScope.createdUser}";
		var currentLevel = "${sessionScope.createdLevel}";
		//댓글 등록 - 등록 버튼(.reply-add-btn)을 클릭하면 정보를 서버로 전송
		// - 전송할 정보 : 댓글 내용(replyContent), 소속글 번호(replyOrigin)
		$(".reply-add-btn").click(function(){
			//step 1 - 작성된 내용을 읽는다.
			var content = $(".reply-input").val();
			if(content.length == 0) return;
			
			//step 2 - 비동기 통신을 보낸다.
			$.ajax({
				url:"/rest/reply/write",
				method:"post",
				data:{
					replyContent: content,
					replyOrigin: boardNo
				},
				success:function(response){
					console.log("댓글 등록 완료");
					$(".reply-input").val("");//댓글 내용 삭제
					
					//목록 다시 불러오기
					loadList();
				}
			});
		});
		
		//댓글 목록 처리
		loadList();//최초 1회 호출			
		function loadList(){
			
			//목록 불러오기
			$.ajax({
				url:"/rest/reply/list",
				method:"post",
				data:{replyOrigin : boardNo},
				success: function(response){//response는 List<ReplyDto>
			//기존 내용 삭제
			$(".reply-list-wrapper").empty();
				//전달된 댓글 개수만큼 반복하여 화면 생성
					for(var i=0; i < response.length; i++){
						//[1] 템플릿을 불러온다
						var template = $("#reply-template").text();
						
						//[2] HTML로 변환 (파싱)
						var html = $.parseHTML(template);
						
						//[3] 탐색하여 값을 치환
						$(html).find(".image-wrapper").children("img").attr("src", "/member/image?memberId="+response[i].replyWriter)
						$(html).find(".reply-title").text(response[i].replyWriter);
						$(html).find(".reply-content").text(response[i].replyContent);
						//(+추가) momentJS를 이용해서 시간을 원하는 형식으로 변경
// 						var time = moment(response[i].replyWtime).fromNow();
						var time = moment(response[i].replyWtime).format("YYYY-MM-DD dddd HH:mm:ss");
						$(html).find(".reply-info > .time").text(time);
						
						//(+추가) 현재 사용자가 작성자인 경우만 버튼을 남기고 나머지는 삭제
						//- 현재 사용자의 정보는 HttpSession(백엔드)에 있다.
						
						if(currentUser == response[i].replyWriter){ //작성자가 현재 사용자와 같으면
						//(+추가) 수정과 삭제버튼에 글 번호를 넣어야 한다.(data-reply-no)
						$(html).find(".reply-edit-btn, .reply-delete-btn")
										.attr("data-reply-no", response[i].replyNo);
						}
						else if(currentLevel == "관리자"){
							$(html).find(".reply-edit-btn, .reply-delete-btn")
							.attr("data-reply-no", response[i].replyNo);
						}
						else{ //작성자가 남이라면
							$(html).find(".reply-edit-btn, .reply-delete-btn")
							.remove();
						}
						//[4] 영역에 추가
						$(".reply-list-wrapper").append(html);
						
					}
				}
			});
		}
		
		//삭제 버튼을 누르면 댓글이 지워지도록 구현
		//- (문제점) 삭제 버튼이 생기기 전에 선택을 하여 대상이 존재하지 않음
		//- (해결) 생성 시 설정 / 문서 전체에 이벤트 설정
		//$(".reply-delete-btn").click(function(e){//있을지 없을지 모름
		$(document).on("click", ".reply-delete-btn", function(e){
			e.preventDefault(); //기본 이벤트 차단
			var choice = window.confirm("정말 삭제하시겠습니까?");
			if(choice == false) return;
			//this == 클릭당한 삭제 버튼
			//태그에 존재하는 data-reply-no를 읽어서 나온 번호로 댓글 삭제 요청
			var replyNo = $(this).attr("data-reply-no");
			
			$.ajax({
				url:"/rest/reply/delete",
				method:"post",
				data:{replyNo : replyNo},
				success:function(response){
					loadList();
				}
			});
		});

	
		// 이 페이지의 파라미터 중에서 boardNo의 값을 알아내는 코드
		var params = new URLSearchParams(location.search);
		var boardNo = params.get("boardNo");
		
		// 페이지가 만들어진 뒤 좋아요 기록을 확인해서 하트와 숫자를 구현
		$.ajax({
			url: "/rest/board/check",
			method:"post",
			data:{boardNo : boardNo},
			success: function(response){
// 				console.log(response);
				if(response.checked){
					$(".fa-heart").removeClass("fa-solid fa-regular").addClass("fa-solid");
				}
				else{
					$(".fa-heart").removeClass("fa-solid fa-regular").addClass("fa-regular");
				}
				//하트 뒤에 있는 span에 개수 적으세요
				$(".fa-heart").next("span").text(response.count);
			}
		});
		
		//수정 버튼 이벤트 처리
		$(document).on("click", ".reply-edit-btn", function(e){
			e.preventDefault();//기본 이벤트 차단
			
			//기존에 열려있는 수정 화면을 모두 제거
			$(".reply-wrapper").show();
			$(".reply-edit-wrapper").remove();
			
			//[1] 편집용 화면을 생성
			var template = $("#reply-edit-template").text();
			var html = $.parseHTML(template);
			$(this).parents(".reply-wrapper").after(html);
			
			//[2] 표시용 화면을 숨김
			$(this).parents(".reply-wrapper").hide();
			
			//[3] 값을 복사 - 프로필 src, 댓글 작성자, 댓글 내용
			var src = $(this).parents(".reply-wrapper").find(".image-wrapper > img").attr("src");
			$(html).find(".image-wrapper > img").attr("src", src);
			var replyWriter = $(this).parents(".reply-wrapper").find(".reply-title").text();
			$(html).find(".reply-title").text(replyWriter);
			var replyContent = $(this).parents(".reply-wrapper").find(".reply-content").text();
			$(html).find(".reply-edit-input").val(replyContent);
			
			//[4] 완료버튼에 글번호 전달
			var replyNo = $(this).attr("data-reply-no");
			$(html).find(".reply-done-btn").attr("data-reply-no", replyNo);
		});
		
		//취소 버튼
		$(document).on("click", ".reply-cancel-btn", function(){
			//[1] 표시용 화면을 숨김 해제
			$(this).parents(".reply-edit-wrapper").prev(".reply-wrapper").show();
			
			//[2] 편집용 화면을 제거한다.
			$(this).parents(".reply-edit-wrapper").remove();
		});
		
		//완료 버튼
		$(document).on("click", ".reply-done-btn", function(){
			//this를 이용해서 글번호(replyNo)와 글 내용(replyContent)를 알아내야 한다.
			var replyContent = $(this).parents(".reply-edit-wrapper").find(".reply-edit-input").val();
			var replyNo = $(this).attr("data-reply-no");
			
			//댓글 내용이 없으면 알림 메세지 출력 후 중지
			if(replyContent.length == 0){
				window.alert("댓글 내용은 반드시 작성해야 합니다.");
				return;
			}
			
			//서버로 댓글 수정을 위한 정보를 전송
			$.ajax({
				url:"/rest/reply/edit",
				method:"post",
				data:{
					replyNo : replyNo,
					replyContent : replyContent
				},
				success:function(response){
					loadList();
					
				}
			});
			
		});
	});
</script>
<!--  댓글 탬플릿 -->
<script type="text/template" id="reply-template">
<!-- 	댓글 1개 영역	 -->
<div class="reply-wrapper">
<!-- 		프로필 영역 -->
	<div class="image-wrapper">
		<img src="https://placehold.it/100x100">
	</div>
<!-- 		내용 영역 -->
	<div class="content-wrapper">
		<div class="reply-title">댓글 작성자</div>
		<div class="reply-content">댓글 내용</div>
		<div class="reply-info">
			<span class="time">
				yyyy-MM-dd HH:mm:ss
			</span>
			<a href="#" class="link link-animation reply-edit-btn">수정</a>
			<a href="#" class="link link-animation reply-delete-btn">삭제</a>
		</div>
	</div>
</div>
</script>
<script type="text/template" id="reply-edit-template">
	<div class="reply-wrapper reply-edit-wrapper">
<!-- 프로필 영역 -->
		<div class="image-wrapper">
			<img src="https://picsum.photos/100">
		</div>
		<div class="content-wrapper">
			<div class="reply-title">댓글 작성자</div>
			<textarea class="field w-100 reply-edit-input"></textarea>
			<div class="right">
				<button class="btn btn-neutral reply-cancel-btn">취소</button>
				<button class="btn btn-positive reply-done-btn">완료</button>
			</div>
		</div>
	</div>
</script>

<c:if test="${sessionScope.createdUser != null}">
<script type="text/javascript">
	//(회원 전용) 하트를 누르면 좋아요 처리를 수행
	$(function(){
		$(".fa-heart")
		.css
		var params = new URLSearchParams(location.search);
		var boardNo = params.get("boardNo");
		$(".fa-heart").click(function(){
			$.ajax({
				url: "/rest/board/action",
				method:"post",
				data:{boardNo : boardNo},
				success: function(response){
//	 				console.log(response);
					if(response.checked){
						$(".fa-heart").removeClass("fa-solid fa-regular").addClass("fa-solid red");
					}
					else{
						$(".fa-heart").removeClass("fa-solid fa-regular red").addClass("fa-regular");
					}
					//하트 뒤에 있는 span에 개수 적으세요
					$(".fa-heart").next("span").text(response.count);
				}
			});
		})
	});
</script>



</c:if>
<div class="container w-800">
<table border= "1">
	<thead align= "center">
		<tr>
			<th>번호</th>
			<th width = "400"  >제목</th>
			<th>글쓴이</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody >
		<tr>
			<td align= "center">${boardDto.boardNo}</td>
			<td align= "center">${boardDto.boardTitle}</td>
			<td align= "center">${boardDto.boardWriterString}</td>
	<c:choose>
		<c:when test= "${boardDto.boardUtime == null}">
			<td align= "center"><fmt:formatDate value="${boardDto.boardWtime}" pattern="yyyy년 MM월 dd일 kk:mm"/> </td>
		</c:when>
		<c:otherwise>
			<td align= "center"><fmt:formatDate value="${boardDto.boardUtime}" pattern="yyyy년 MM월 dd일 kk:mm"/>(수정됨)</td>
		</c:otherwise>
	</c:choose>
			<td align= "center">${boardDto.boardViews}</td>
		</tr>
		<tr>
			<td></td>
				<td colspan= "4" height= "400" valign= "top">
					<!-- pre 태그는 내용을 작성된 형태 그대로 출력한다 -->
					
					<pre>${boardDto.boardContent}</pre>
				</td>
		</tr>
	</tbody>
	<tfoot>
		<td colspan="2"></td>
		
		<td><i class="fa-solid fa-heart"></i>
		<span>0</span></td>
		<td><a href= "#">추천</a></td>
	</tfoot>
</table>
<!-- 댓글 목록 -->
<div class="row reply-list-wrapper">

</div>

<!-- 댓글작성 -->
<div class="row">
	<textarea class="field w-100 reply-input"></textarea>
	<button type="button" class="btn btn-positive w-100 reply-add-btn"><i class="fa-solid fa-pen"></i> 댓글 작성</button>
</div>
</div>
		<h2 align= "right"><a href= "/board/list">목록으로</a></h2>
		
		<c:set var= "isAdmin" value="$sessionScope.createdLevel == '관리자'}"/>
		<c:set var= "isLogin" value="$sessionScope.createdUser != null}"/>
		<c:set var= "isOwner" value="$sessionScope.createdUser == boardDto.boardWriter}"/>
<c:choose>
	<c:when test= "${sessionScope.createdUser == null}">
	</c:when>
	<c:when test= "${sessionScope.createdUser == boardDto.boardWriter}">
		<h2 align= "right"><a href= "write?boardTarget=${boardDto.boardNo}">답글달기</a></h2>
		<h2 align= "right"><a href= "/board/update?boardNo=${boardDto.boardNo}">수정하기</a></h2>
		<h2 align= "right"><a href= "/board/delete?boardNo=${boardDto.boardNo}">삭제하기</a></h2>
	</c:when>
	<c:when test= "${sessionScope.createdLevel == '관리자'}">
		<h2 align= "right"><a href= "/board/delete?boardNo=${boardDto.boardNo}">삭제하기</a></h2>
	</c:when>
</c:choose>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
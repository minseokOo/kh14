<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<script type="text/javascript">
	$(function(){
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
		
	});
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
						$(".fa-heart").removeClass("fa-solid fa-regular").addClass("fa-solid");
					}
					else{
						$(".fa-heart").removeClass("fa-solid fa-regular").addClass("fa-regular");
					}
					//하트 뒤에 있는 span에 개수 적으세요
					$(".fa-heart").next("span").text(response.count);
				}
			});
		})
	});
</script>
</c:if>
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
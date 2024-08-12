<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<style>
	.btn.btn-neutral {
		padding: 1px;
	}
</style>
<div class="container w-900 my-50">
<div class="row">
<h1>글 목록</h1>
</div>
<!-- <div> -->
<%-- 	${pageVO} --%>
<!-- </div> -->
<%-- <div>${pageVO.beginRow} - ${pageVO.count} / ${pageVO.endRow} 개</div> --%>

<div class="row">
<table class="table table-border table-stripe table-hover"  border= "1" width= "1000" >
	<thead align= "center">
		<tr>
			<th>번호</th>
			<th width= "40%">제목</th>
			<th>작성자</th>
			<th>작성시간</th>
			<th>조회수</th>
			<th>좋아요</th>
			<th>번호</th>
			<th>그룹</th>
			<th>상위</th>
			<th>차수</th>
		</tr>
	</thead>
	<tbody align= "center" >
		<c:forEach var= "boardDto" items= "${boardList}">
			<tr>
				<td>${boardDto.boardNo}</td>
				<!-- HTML 특수문자를 이용하여 띄어쓰기 추가 -->
				
				<td align= "left">
				<c:forEach var= "i" begin= "1" end= "${boardDto.boardDepth}" step= "1">
				&nbsp;&nbsp;
				</c:forEach>
				<c:if test= "${boardDto.boardDepth > 0}">
					<img src= "/images/reply.png" width= "15" height="16">
				</c:if>
				<a href= "/board/read?boardNo=${boardDto.boardNo}" >${boardDto.boardTitle}</a> (${boardDto.boardReplies})</td>
<%-- 				<c:choose> --%>
<%-- 					<c:when test= "${boardDto.boardWriter == null}"> --%>
<%-- 						<td>탈퇴한 사용자</td> --%>
<%-- 					</c:when> --%>
<%-- 					<c:otherwise><td>${boardDto.boardWriter}</td></c:otherwise> --%>
<%-- 				</c:choose> --%>
				<td>${boardDto.boardWriterString}</td>
				<td>${boardDto.boardWtimeString}</td>
				<td>${boardDto.boardViews}</td>
				<td>${boardDto.boardLikes}</td>
				<td>${boardDto.boardNo}</td>
				<td>${boardDto.boardGroup}</td>
				<td>${boardDto.boardTarget}</td>
				<td>${boardDto.boardDepth}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>

<!-- 네비게이터 불러오는 코드 -->
<jsp:include page= "/WEB-INF/views/template/navigator.jsp"/>

<%-- 비회원일 때와 회원일 때 다르게 보이도록 처리 --%>
<div class="row right">
<c:choose>
	<c:when test= "${sessionScope.createdUser != null}">
		<h2><a class="btn btn-neutral" href= "/board/write">글쓰기</a></h2>
	</c:when>
	<c:otherwise>
		<h2><a title= "로그인 후 사용 가능합니다.">글쓰기</a></h2>
	</c:otherwise>
</c:choose>	
</div>

<form action="list" method="get">
	<select name= "column">
		<option value= "board_title">제목</option>
		<option value= "board_writer">작성자</option>
	</select>
	<input type= "text" name= "keyword" placeholder= "검색어" value="${param.keyword}"> 
	<button>검색</button>
</form>
</div>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
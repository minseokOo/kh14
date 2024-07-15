<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<h1>글 목록</h1>

<h2>데이터 개수 : ${list.size()}</h2>
<table border= "1" >
	<thead align= "center">
		<tr>
			<th>번호</th>
			<th width= "300">제목</th>
			<th>작성자</th>
			<th>작성시간</th>
			<th>조회수</th>
			<th>좋아요</th>
		</tr>
	</thead>
	<tbody align= "center">
		<c:forEach var= "boardDto" items= "${list}">
			<tr>
				<td>${boardDto.boardNo}</td>
				<td align= "left"><a href= "/board/read?boardNo=${boardDto.boardNo}">${boardDto.boardTitle}</a></td>
<%-- 				<c:choose> --%>
<%-- 					<c:when test= "${boardDto.boardWriter == null}"> --%>
<%-- 						<td>탈퇴한 사용자</td> --%>
<%-- 					</c:when> --%>
<%-- 					<c:otherwise><td>${boardDto.boardWriter}</td></c:otherwise> --%>
<%-- 				</c:choose> --%>
				<td>${boardDto.boardWriterString}</td>
				<td>${boardDto.boardWtime}</td>
				<td>${boardDto.boardViews}</td>
				<td>${boardDto.boardLikes}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<br>
<!-- 네비게이터 -->
<h3>이전 1 2 3 4 5 6 7 8 9 다음</h3>

<c:choose>
	<c:when test= "${sessionScope.createdUser != null}">
		<h2><a href= "/board/write">글쓰기</a></h2>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>	

<form action="list" method="get">
	<select name= "column">
		<option value= "board_title">제목</option>
		<option value= "board_writer">작성자</option>
	</select>
	<input type= "text" name= "keyword" placeholder= "검색어" value="${param.keyword}"> 
	<button>검색</button>
</form>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
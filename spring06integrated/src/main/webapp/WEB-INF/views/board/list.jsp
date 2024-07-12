<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<h1>글 목록</h1>

<h2>데이터 개수 : ${list.size()}</h2>
<table border= "1">
	<thead>
		<tr>
			<th>번호</th>
			<th width= "400">제목</th>
			<th>작성자</th>
			<th>작성시간</th>
			<th>조회수</th>
			<th>좋아요</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var= "boardDto" items= "${list}">
			<tr>
				<td>${boardDto.boardNo}</td>
				<td>${boardDto.boardTitle}</td>
				<td>${boardDto.boardWriter}</td>
				<td>${boardDto.boardWtime}</td>
				<td>${boardDto.boardViews}</td>
				<td>${boardDto.boardLikes}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
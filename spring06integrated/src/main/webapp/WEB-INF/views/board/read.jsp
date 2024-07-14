<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
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
			<td align= "center">${boardDto.boardWriter}</td>
			<td align= "center">${boardDto.boardWtime}</td>
			<td align= "center">${boardDto.boardViews}</td>
		</tr>
		<tr>
			<td></td>
			<td colspan= "4" height= "400" valign= "top">${boardDto.boardContent}</td>
		</tr>
	</tbody>
	<tfoot>
		<td colspan="2"></td>
		<td>좋아요 : ${boardDto.boardLikes}</td>
		<td><a href= "#">추천</a>
	</tfoot>
</table>
<h2><a href= "/board/list">목록으로</a></h2>
	<c:if test= "${sessionScope.createdUser == boardDto.boardWriter}">
		<h2><a href= "/board/update?boardNo=${boardDto.boardNo}">수정하기</a></h2>
		<h2><a href= "/board/delete?boardNo=${boardDto.boardNo}">삭제하기</a></h2>
	</c:if>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container center w-800">
<div class="row center">
<h1>글 목록</h1>
</div>

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
				<td align= "left"><a href= "/board/read?boardNo=${boardDto.boardNo}">${boardDto.boardTitle}</a> (${boardDto.boardReplies})</td>
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
			</tr>
		</c:forEach>
	</tbody>
</table>
<br>
<!-- 네비게이터 -->
<%-- 이전 버튼은 첫 번째 구간이 아닐 때(startBlock > 1) 나온다. --%>
<div class="pagination">
<c:if test="${pageVO.hasPrev()}">
<a href= "list?column=${pageVO.column}&keyword=${pageVO.keyword}&page=${pageVO.prevBlock}">이전</a> 
</c:if>
<%-- 
	startBlock부터 
	finishBlock과 lastBlock중 작은 값 까지
 	반복문으로 링크 출력 
--%>
<c:forEach var= "n" begin= "${pageVO.startBlock}" 
										end="${pageVO.finishBlock}" step="1">
	<c:choose>
		<c:when test= "${pageVO.page == n}">
			<a>${n}</a>
		</c:when>
		<c:otherwise>
			<a href="list?column=${pageVO.column}&keyword=${pageVO.keyword}&page=${n}">${n}</a>
		</c:otherwise>
	</c:choose>
</c:forEach>
<%--다음 버튼은 마지막 구간이 아닐 때(finishBlock < lastBlock) 나온다 --%>
<c:if test= "${pageVO.hasNext()}">
	<a href= "list?column=${pageVO.column}&keyword=${pageVO.keyword}&page=${pageVO.nextBlock}">다음</a></h3>
</c:if>
</div>
<%-- 비회원일 때와 회원일 때 다르게 보이도록 처리 --%>
<c:choose>
	<c:when test= "${sessionScope.createdUser != null}">
		<h2><a class="btn btn-neutral"  href= "/board/write">글쓰기</a></h2>
	</c:when>
	<c:otherwise>
		<h2><a title= "로그인 후 사용 가능합니다.">글쓰기</a></h2>
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
</div>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
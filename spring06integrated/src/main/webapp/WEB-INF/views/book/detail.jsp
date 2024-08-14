<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri= "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<div class="container w-500">
<h1>도서 상세 정보</h1>

<%--(추가) 전달된 도서 이미지(images) 번호를 이용하여 이미지 태그를 생성 --%>
<c:choose>
	<c:when test= "${images.isEmpty()}">
		<h3>이 도서는 미리보기 이미지가 없습니다.</h3>
	</c:when>
	<c:otherwise>
		<c:forEach var= "no" items= "${images}">
			<img src= "/attach/download?attachmentNo=${no}" width="50" height="50">
		</c:forEach>
	</c:otherwise>
</c:choose>
    <table border= "1">
    	<tr>
    		<th>번호</th>
    		<td>${dto.bookId}</td>
    	</tr>
    	<tr>
    		<th>제목</th>
    		<td>${dto.bookTitle}</td>
    	</tr>
    	<tr>
    		<th>작가</th>
    		<td>${dto.bookAuthor}</td>
    	</tr>
    	<tr>
    		<th>출판일</th>
    		<td>${dto.bookPublicationDate}</td>
    	</tr>
    	<tr>
    		<th>가격</th>
    		<td>${dto.bookPrice}</td>
    	</tr>
    	<tr>
    		<th>출판사</th>
    		<td>${dto.bookPublisher}</td>
    	</tr>
    	<tr>
    		<th>페이지수</th>
    		<td>${dto.bookPageCount}</td>
    	</tr>
    	<tr>
    		<th>장르</th>
    		<td>${dto.bookGenre}</td>
    	</tr>
    	
    </table>
    <div class= "row right">
    <h2><a class="btn btn-neutral" href= "list">목록보기</a></h2>
    <h2><a class="btn btn-neutral" href="delete?bookId=${dto.bookId}">삭제하기</a></h2>
    <h2><a class="btn btn-neutral" href= "edit">수정하기</a></h2>
    </div>
</div>
    
    <jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>도서 목록</h1>

<form action= "list" method= "get">
	<select name= "column">
		<option value= "book_title">도서명</option>
		<option value= "book_author"> <c:if test="${column == 'book_author'}">selected</c:if></option>
		
	</select>

</form>

<h2>데이터 개수 : ${list.size()}</h2>
<table border= "1">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작가</th>
			<th>출판일</th>
			<th>가격</th>
			<th>출판사</th>
			<th>페이지수</th>
			<th>장르</th>
		</tr>
	</thead>
	<tbody align= "center">
	<c:forEach var= "dto" items= "${list}">
		<tr>
			<td>${dto.bookId}</td>
			<td><a href= "detail?bookId=${dto.bookId}">${dto.bookTitle}</a></td>
			<td>${dto.bookAuthor}</td>
			<td>${dto.bookPublicationDate}</td>
			<td>${dto.bookPrice}</td>
			<td>${dto.bookPublisher}</td>
			<td>${dto.bookPageCount}</td>
			<td>${dto.bookGenre}</td>
		</tr>
	</c:forEach>
	</tbody>		
</table>

<h2><a href= "save">추가 등록하기</a></h2>

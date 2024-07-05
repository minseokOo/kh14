<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri= "http://java.sun.com/jsp/jstl/fmt" %>

<h1>도서 상세 정보</h1>

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
    
    <h2><a href= "list">목록보기</a></h2>
    <h2><a href="delete?bookId=${dto.bookId}">삭제하기</a></h2>
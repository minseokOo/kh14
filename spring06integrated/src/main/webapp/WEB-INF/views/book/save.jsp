<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h1>책 목록 추가</h1>
    <br><br>
    <form action= "./save" method= "get">
    책 제목
    <input type= "text" name= "bookTitle" required autocomplete= "off">
	<br>
	작가
	<input type= "text" name= "bookAuthor" required autocomplete= "off">
	<br>
	출판일 
	<input type="date" name="bookPublicationDate" required>
	<br>
	가격
	<input type= "number" name= "bookPrice" required autocomplete= "off">
	<br>
	출판사
	<input type= "text" name= "bookPublisher" required autocomplete= "off">
	<br>
	페이지수
	<input type= "number" name= "bookPageCount" required autocomplete= "off">
	<br>
	장르
	<input type= "text" name= "bookGenre" required autocomplete= "off">
	<br>
	<button>등록</button>
</form>

<h2><a href="list">목록으로 돌아가기</a></h2>
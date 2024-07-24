<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
    <style>
        .btn.btn-positive{
            background-color: rgb(139, 139, 255);
            border: none;
            border-radius: 3px;
        }
    </style>
    <div class="container left w-300">
        <h1>책 목록 추가</h1>
    <form action= "./save" method= "get" enctype= "multipart/form-data">
    
    <div class="row">
    제목<input class="field w-100" type= "text" name= "bookTitle" required autocomplete= "off">
</div>
<div class="row">
	작가<input class="field w-100" type= "text" name= "bookAuthor" required autocomplete= "off">
</div>
<div class="row">
	출판일<input class="field w-100" type="date" name="bookPublicationDate" required>
</div>
<div class="row">
    가격
    <input class="field w-100" type= "number" name= "bookPrice" required autocomplete= "off">
</div>
    <div class="row">
        출판사
        <input class="field w-100" type= "text" name= "bookPublisher" required autocomplete= "off">
	</div>
    <div class="row">
        페이지수
        <input class="field w-100" type= "number" name= "bookPageCount" required autocomplete= "off">
	</div>
    <div class="row">
        장르
        <input class="field w-100" type= "text" name= "bookGenre" required autocomplete= "off">
	</div>
    <div class="row">
        첨부파일<input class="field w-100" type= "file" name= "attachList" multiple accept= "image/*">
    </div>
    <div class="row right">
	<button class="btn btn-positive">등록</button>
	</div>
	<div class="row">
<h2><a class="btn btn-neutral" href="list">목록으로 돌아가기</a></h2>
</div>
</form>
</div>
</body>
</html>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>

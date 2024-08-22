<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
    
<div class="container w-500 my-50">
	<div class= "row center">
		<h1>비밀번호 찾기</h1>
	</div>
	<form action= "findPw" method="post">
	<div class="row">
		<label>아이디</label>
		<input type="text" name= "memberId" class="field w-100">
	</div>
	<div class="row">
		<label>이메일</label>
		<input type="email" name="memberEmail" class="field w-100">
	</div>
	<div class="row">
		<button type="submit" class="btn btn-positive">임시 비밀번호 발행</button>
	</div>
	</form>

</div>    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
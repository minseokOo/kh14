<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
    
    <h1>비밀번호 변경</h1>
    
    <form action= "password" method= "post">
    	현재 비밀번호 <input type= "password" name= "currentPw" required><br><br>
    	바꿀 비밀번호 <input type= "password" name= "changePw" required><br><br>
    	
    <button>변경하기</button>
    </form>
    
<c:if test= "${param.error != null}">
	<h3 style="color:red">비밀번호가 일치하지 않습니다</h3>
</c:if>
    
    
    
    
    
    
    <jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
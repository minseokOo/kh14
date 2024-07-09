<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
    <h1>회원 탈퇴</h1>
    
    <form action="exit" method="post" >
    비밀번호 입력 <input type="password"  name= "memberPw" required><br><br>
    
    <button>확인</button>
    </form>

<c:if test= "${param.error != null}">
	<h3 style="color:red">비밀번호가 틀렸습니다.</h3>
</c:if>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

    <h2>로그인 페이지</h2>
    <form action= "login" method= "post">
    아이디* <input type="text"  name= "memberId" required> <br><br>
    비밀번호* <input type= "password" name= "memberPw" required><br><br>
    
    	<button>로그인</button>
    </form>

<%--error라는 이름의 파라미터가 있으면 오류 메세지를 출력 --%>
<c:if test= "{param.error != null}">
	<h3 style = "color:red">아이디 또는 비밀번호가 잘못되었습니다.</h3>
</c:if>
    
    
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
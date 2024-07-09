<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>개인정보 변경</h1>

<form action= "change" method= "post">
	닉네임* <input type="text" name= "memberNickname" value="${memberDto.memberNickname}"  required><br><br>
	이메일* <input type= "text" name= "memberEmail"  value= "${memberDto.memberEmail}" required><br><br>
	생년월일 <input type= "date" name= "memberBirth"  value="${memberDto.memberBirth}"><br><br>
	연락처 <input type= "text" name= "memberContact" value="${memberDto.memberContact}"><br><br>
	우편번호 <input type="text" name= "memberPost" value="${memberDto.memberPost}"><br>
	주소 <input type= "text" name= "memberAddress1" value="${memberDto.memberAddress1}"><br>
	상세 주소 <input type= "text" name= "memberAddress2" value="${memberDto.memberAddress2}"><br><br>
	
	비밀번호 확인* <input type="password" name="memberPw"><br><br>
<button>변경하기</button>
</form>

<c:if test= "${param.error != null}">
	<h3 style="color:red">비밀번호가 틀렸습니다.</h3>
</c:if>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
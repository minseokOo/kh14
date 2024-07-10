<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
	<h1>회원 정보 변경[관리자]</h1>
	<form action= "edit" method= "post">
		<input type= "hidden" name="memberId" value="${memberDto.memberId}">
		닉네임<input type="text" name= "memberNickname" value="${memberDto.memberNickname}" required><br><br>
		이메일<input type="text" name= "memberEmail" value="${memberDto.memberEmail}" required><br><br>
		연락처<input type="text" name= "memberContact" value="${memberDto.memberContact}" ><br><br>
		생년월일<input type="date" name= "memberBirth" value="${memberDto.memberBirth}" ><br><br>
		등급<select name= "memberLevel" >
			<option value= "일반회원" >일반회원</option>
			<option value= "우수회원">우수회원</option>
		</select><br><br>
		포인트<input type="number" name= "memberPoint" value="${memberDto.memberPoint}" ><br><br>
		우편번호<input type="text" name= "memberPost"  value="${memberDto.memberPost}"><br><br>
		주소<input type="text" name= "memberAddress1"  value="${memberDto.memberAddress1}"><br><br>
		상세주소<input type="text" name= "memberAddress2"  value="${memberDto.memberAddress2}">
	
	<button>변경</button>
	</form>
	

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
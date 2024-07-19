<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<h1>상세 회원 정보</h1>

<img src= "/member/image?memberId=${memberDto.memberId}" width= "100" height= "100">

<table border= "1">
	<tr>
		<th>회원 ID</th>
		<td>${memberDto.memberId}</td>
	</tr>
	<tr>
		<th>닉네임</th>
		<td>${memberDto.memberNickname}</td>
	</tr>
	<tr>
		<th>생일</th>
		<td>${memberDto.memberBirth}</td>
	</tr>
	<tr>
		<th>전화번호</th>
		<td>${memberDto.memberContact}</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${memberDto.memberEmail}</td>
	</tr>
	<tr>
		<th>회원 등급</th>
		<td>${memberDto.memberLevel}</td>
	</tr>
	<tr>
		<th>포인트</th>
		<td>${memberDto.memberPoint}</td>
	</tr>
	<tr>
		<th>주소</th>
		<td>${memberDto.memberPost}
		${memberDto.memberAddress1}
		${memberDto.memberAddress2}</td>
	</tr>
	<tr>
		<th>회원가입일</th>
		<td>${memberDto.memberJoin}</td>
	</tr>
	<tr>
		<th>최종 로그인</th>
		<td>${memberDto.memberLogin}</td>
	</tr>
	
</table>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
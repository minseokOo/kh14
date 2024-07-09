<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>${memberDto.memberId} 님의 개인 정보</h1>

<table border="1" width="400">
	<tr>
		<th width= "25">닉네임</th>
		<td>${memberDto.memberNickname}</td>
	</tr>
	<tr>
		<th>생년월일</th>
		<td>${memberDto.memberBirth}</td>
	</tr>
	<tr>
		<th>연락처</th>
		<td>${memberDto.memberContact}</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${memberDto.memberEmail}</td>
	</tr>
	<tr>
		<th>등급</th>
		<td>${memberDto.memberLevel}</td>
	</tr>
	<tr>
		<th>포인트</th>
		<td>
		<fmt:formatNumber value= "${memberDto.memberPoint}" pattern= "#,##0"></fmt:formatNumber>
		 p</td>
	</tr>
	<tr>
		<th>주소</th>
		<td>
		[${memberDto.memberPost}]
		${memberDto.memberAddress1}
		${memberDto.memberAddress2}
		</td>
	</tr>
	<tr>
		<th>가입일</th>
		<td>
		<fmt:formatDate value="${memberDto.memberJoin}"  pattern="y년-M월-d일 E H시 m분 s초"/>
		 </td>
	</tr>
	<tr>
		<th>최종로그인</th>
		<td><fmt:formatDate value="${memberDto.memberLogin}"  pattern="y년-M월-d일 E H시 m분 s초"/> </td>
	</tr>
	
</table>

<!-- 각종 메뉴를 배치 -->
<h4><a href= "change">개인정보 수정</a></h4>
<h4><a href= "password">비밀번호 변경</a></h4>










<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
    
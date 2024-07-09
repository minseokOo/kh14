<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

    <h1>사용자 목록 검색</h1>
   
    <form action= "list" method= "get">
    	<select name= "column">
    		<option value= "member_id">아이디</option>
    		<option value= "member_nickname">닉네임</option>
    		<option value= "member_email">이메일</option>
    		<option value= "member_level">등급</option>
    	</select>
    	<input type= "text" name= "keyword">
    	<button>검색</button>
    </form>
    
    <h2>데이터 개수 : ${list.size()}</h2>
	<c:if test= "${keyword != null}">
<table border= "1">
	<thead>
		<tr>
		<th>아이디</th>
		<th>닉네임</th>
		<th>이메일</th>
		<th>등급</th>
		<th>가입일</th>
		</tr>
	</thead>
    <tbody>
	<c:forEach var= "dto" items="${list}">
		<tr>
			<td>${dto.memberId}</td>
			<td>${dto.memberNickname}</td>
			<td>${dto.memberEmail}</td>
			<td>${dto.memberLevel}</td>
			<td>${dto.memberJoin}</td>
		</tr>
	</c:forEach>
	
	</tbody>
	</c:if>
	</table>
    <jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
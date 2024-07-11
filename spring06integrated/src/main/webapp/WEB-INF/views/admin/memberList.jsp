<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

    <h1>사용자 목록 검색</h1>
   
    <form action= "list" method= "get">
    	<select name= "column">
    		<option value= "member_id" >아이디</option>
    		<option value= "member_nickname">닉네임</option>
    		<option value= "member_email">이메일</option>
    		<option value= "member_level">등급</option>
    	</select>
<!--     </form> -->
<%--     	<c:choose> --%>
<!--     <form action= "list" method= "get"> -->
<%--     		<c:when test= "${column == 'member_level'}"> --%>
<!--     			<select name= "keyword"> -->
<!--     				<option value= "일반회원">일반회원</option> -->
<!--     				<option value= "우수회원">우수회원</option> -->
<!--     				<option value= "관리자">관리자</option> -->
<!--     			</select> -->
<%--     		</c:when> --%>
<%--     		<c:otherwise> --%>
    			<input type= "text" name= "keyword">
<%--     		</c:otherwise> --%>
    	<button>검색</button>
    </form>
<%--     	</c:choose> --%>
    
<%--     <h2>데이터 개수 : ${list.size()}</h2> --%>
    
    <c:if test= "${list.isEmpty()}">
    	<h3>검색 결과가 존재하지 않습니다</h3>
    </c:if>
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
			<td>
				<a href= "detail?memberId=${dto.memberId}">상세</a>
				<a href= "edit?memberId=${dto.memberId}">수정</a>
				<a href= "block?blockTarget=${dto.memberId}">차단</a>
				<a href= "cancel?blockTarget=${dto.memberId}">해제</a>
				<a href= "delete?memberId=${dto.memberId}">삭제</a>
			</td>
		</tr>
	</c:forEach>
	
	</tbody>
	</table>
	</c:if>
    <jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
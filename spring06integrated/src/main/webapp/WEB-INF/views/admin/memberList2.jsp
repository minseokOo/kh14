<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

    <h1>사용자 목록 검색</h1>
   <div>
   	${pageVO}
   </div>
   <div>${pageVO.beginRow} -  ${pageVO.count} / ${pageVO.endRow} 개</div>
	<form action="list" method="get">
		<select name="column">
			<option value="member_id" <c:if test="${param.column == 'member_id'}">selected</c:if>>아이디</option>
			<option value="member_nickname" <c:if test="${param.column == 'member_nickname'}">selected</c:if>>닉네임</option>
			<option value="member_email" <c:if test="${param.column == 'member_email'}">selected</c:if>>이메일</option>
			<option value="member_level" <c:if test="${param.column == 'member_level'}">selected</c:if>>등급</option>
		</select>
		<input type="search" name="keyword" placeholder="검색어" required
										value="${param.keyword}">
		<button>검색</button>
	</form>
	<!-- 결과화면 -->
	<hr>
	<c:if test="${list.isEmpty()}">
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
		<th>상태</th>
		</tr>
	</thead>
    <tbody>
	<c:forEach var= "memberBlockVO" items="${list}">
		<tr>
		
			<td>${memberBlockVO.memberId}</td>
			<td>${memberBlockVO.memberNickname}</td>
			<td>${memberBlockVO.memberEmail}</td>
			<td>${memberBlockVO.memberLevel}</td>
			<td>${memberBlockVO.memberJoin}</td>
			<td>${memberBlockVO.blockType}</td>
			<td>
				<a href="detail?memberId=${memberBlockVO.memberId}">상세</a>
					<a href="edit?memberId=${memberBlockVO.memberId}">수정</a>
						<c:choose>
							<c:when test="${memberBlockVO.blockType == '해제'}">
					<a href="block?blockTarget=${memberBlockVO.memberId}">차단</a>
							</c:when>
							<c:otherwise>
					<a href="cancel?blockTarget=${memberBlockVO.memberId}">해제</a>
							</c:otherwise>
						</c:choose>
					<a href="delete?memberId=${memberBlockVO.memberId}">삭제</a>
			</td>
		</tr>
	</c:forEach>
	
	
	
	</tbody>
	</table>
	</c:if>
	<jsp:include page= "/WEB-INF/views/template/navigator.jsp"/>
    <jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
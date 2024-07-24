<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>${memberDto.memberId} 님의 개인 정보</h1>

<img src="myImage" width= "100" height= "100">


<table border="1" width="400">
	<tr>
		<th height= "50">닉네임</th>
		<td>${memberDto.memberNickname}</td>
	</tr>
	<tr>
		<th height= "50">생년월일</th>
		<td>${memberDto.memberBirth}</td>
	</tr>
	<tr>
		<th height= "50">연락처</th>
		<td>${memberDto.memberContact}</td>
	</tr>
	<tr>
		<th height= "50">이메일</th>
		<td>${memberDto.memberEmail}</td>
	</tr>
	<tr>
		<th height= "50">등급</th>
		<td>${memberDto.memberLevel}</td>
	</tr>
	<tr>
		<th height= "50">포인트</th>
		<td>
		<fmt:formatNumber value= "${memberDto.memberPoint}" pattern= "#,##0"></fmt:formatNumber>
		 p</td>
	</tr>
	<tr>
		<th height= "50">주소</th>
		<td>
		[${memberDto.memberPost}]
		${memberDto.memberAddress1}
		${memberDto.memberAddress2}
		</td>
	</tr>
	<tr>
		<th height= "50">가입일</th>
		<td>
		<fmt:formatDate value="${memberDto.memberJoin}"  pattern="y년-M월-d일 E H시 m분 s초"/>
		 </td>
	</tr>
	<tr>
		<th height= "50">최종로그인</th>
		<td><fmt:formatDate value="${memberDto.memberLogin}"  pattern="y년-M월-d일 E H시 m분 s초"/> </td>
	</tr>
	
</table>

<!-- 각종 메뉴를 배치 -->
<h4><a class="btn btn-neutral" href= "change">개인정보 수정</a></h4>
<h4><a class="btn btn-neutral" href= "password">비밀번호 변경</a></h4>
<h4><a class="btn btn-neutral" href= "exit">회원 탈퇴</a></h4>

<h2>차단 이력</h2>

<c:choose>
	<c:when test= "${blockList.isEmpty()}">
		<p>차단 이력이 존재하지 않습니다</p>
	</c:when>

<c:otherwise>
<table border= "1" width= "700">
	<thead>
		<tr>
			<th>차단 이력</th>
			<th>차단/해제 사유</th>
			<th>차단 일시</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var= "blockDto" items= "${blockList}">
			<tr>
				<td>${blockDto.blockType}</td>
				<td>${blockDto.blockMemo}</td>
				<td>
				<fmt:formatDate value="${blockDto.blockTime}"  pattern="y년-M월-d일 E H시 m분 s초"/>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</c:otherwise>
</c:choose>






<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
    
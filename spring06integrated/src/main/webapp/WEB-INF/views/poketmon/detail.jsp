<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<h1>포켓몬스터 상세 정보</h1>

<c:choose>
	<c:when test="${dto == null}">
		<h2>존재하지 않는 몬스터 번호</h2>
	</c:when>
	<c:otherwise>
	<!-- 이미지를 출력 -->
	<img src = "image?poketmonNo=${dto.poketmonNo}" width= "150" height= "150">
	
		<table border="1" width="400">
			<tr>
				<th width="30%">번호</th>
				<td>${dto.poketmonNo}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${dto.poketmonName}</td>
			</tr>
			<tr>
				<th>속성</th>
				<td>${dto.poketmonType}</td>
			</tr>
		</table>
	</c:otherwise>
</c:choose>

<!-- 다른 페이지로 이동할 수 있는 링크 -->
<h2><a href="insert">신규 포켓몬 등록</a></h2>
<h2><a href="list">목록으로 이동</a></h2>

<c:if test= "${dto != null}">
<h2><a href= "edit?poketmonNo=${dto.poketmonNo}">이 몬스터 정보 수정</a></h2>
<h2><a href= "delete?poketmonNo=${dto.poketmonNo}">이 몬스터 삭제하기</a></h2>
</c:if>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
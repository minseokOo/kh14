<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>데이터베이스 현황</h1>

<h2>포켓몬스터 현황</h2>
	<table border= "1" width= "300">
		<thead>
			<tr>
				<th>속성</th>
				<th>개체수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var= "statusVO" items= "${poketmonStatusList}">
			<tr>
				<td>${statusVO.title}</td>
				<td>${statusVO.cnt}</td>
			
			<tr>
			</c:forEach>
		</tbody>
	</table>

<h2>팀별 인원 현황</h2>
	<table border= "1" width= "300">
		<thead>
			<tr>
				<th>부서</th>
				<th>인원수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var= "statusVO" items= "${empDeptStatusList}">
			<tr>
				<td>${statusVO.title}</td>
				<td>${statusVO.cnt}</td>
			
			<tr>
			</c:forEach>
		</tbody>
	</table>
<h2>직급별 인원 현황</h2>
	<table border= "1" width= "300">
		<thead>
			<tr>
				<th>직급</th>
				<th>인원수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var= "statusVO" items= "${empRankStatusList}">
			<tr>
				<td>${statusVO.title}</td>
				<td>${statusVO.cnt}</td>
			
			<tr>
			</c:forEach>
		</tbody>
	</table>
<!-- <h2>장르별 도서 현황</h2> -->
<h2>등급별 회원 현황</h2>
<table border= "1" width= "300">
		<thead>
			<tr>
				<th>등급</th>
				<th>인원수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var= "statusVO" items= "${memberLevelStatusList}">
			<tr>
				<td>${statusVO.title}</td>
				<td>${statusVO.cnt}</td>
			
			<tr>
			</c:forEach>
		</tbody>
	</table>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
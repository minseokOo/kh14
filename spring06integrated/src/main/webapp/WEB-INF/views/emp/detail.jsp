<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix= "fmt" uri= "http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<div class="container w-500">
<h1>상세 사원 정보</h1>
<c:choose>
	<c:when test="${dto == null}">
	 <h2>존재하지 않는 번호</h2>
	</c:when>
	<c:otherwise>
	
	<img src = "image?empNo=${dto.empNo}" width= "150" height= "150">
<table border="1">
	<tr>
		<th>번호</th>
		<td>${dto.empNo}</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${dto.empName}</td>
	</tr>
	<tr>
		<th>부서</th>
		<td>${dto.empDept}</td>
	</tr>
		<tr>
		<th>입사일</th>
		<td>
		${dto.empDate}
		</td>
	</tr>
		<tr>
		<th>직급</th>
		<td>${dto.empRank}</td>
	</tr>
		<tr>
		<th>월급</th>
		<td>
			<fmt:formatNumber value= "${dto.empSal}" pattern= "#,##0.00"></fmt:formatNumber>
		원</td>
	</tr>
</table>
	</c:otherwise>
</c:choose>    

<h2><a class="btn btn-neutral" href="list">사원 목록보기</a></h2>
<h2><a class="btn btn-neutral" href="add">사원 추가하기</a></h2>

<c:if test= "${dto.empNo != null}">
<h2><a class="btn btn-neutral" href= "edit?empNo=${dto.empNo}">사원 수정하기</a></h2>
<h2><a class="btn btn-neutral" href= "delete?empNo=${dto.empNo}">사원 삭제하기</a></h2>
</c:if>
</div>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
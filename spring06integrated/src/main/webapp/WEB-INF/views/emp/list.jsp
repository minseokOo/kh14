<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>



<h1>사원 목록 검색</h1>

<form action="list" method= "get">
	<select name= "column">
		<option value= "emp_name">사원 이름</option>
		<option value= "emp_dept">부서명 </option>
		<option value= "emp_rank">직급 </option>
	</select>
	<input type="text" name= "keyword" >
	<button>검색</button>


</form>

<h2>데이터 개수 : ${list.size()}</h2>
<table border= "1">
	<thead>
		<tr>
		<th>No.</th>
		<th>이름</th>
		<th>부서</th>
		<th>입사일</th>
		<th>직급</th>
		<th>월급</th>
		</tr>
	</thead>
	
	<tbody>
	<c:forEach var= "dto" items="${list}">
		<tr>
			<td>${dto.empNo}</td>
			<td>${dto.empName}</td>
			<td>${dto.empDept}</td>
			<td>${dto.empDate}</td>
			<td>${dto.empRank}</td>
			<td>${dto.empSal}원</td>
			<th><a href= "detail?empNo=${dto.empNo}">상세</a></th>
		</tr>
	</c:forEach>
	
	</tbody>
</table>
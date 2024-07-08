<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>포켓몬 목록</h1>

<form acton= "list" method="get">
	<select name="column" >
		<option value= "poketmon_name">포켓몬 이름</option>
		<c:choose>
			<c:when test= "${column == 'poketmon_type'}">
		<option value= "poketmon_type"selected>포켓몬 타입</option>
		</c:when>
		<c:otherwise>
			<option value= "poketmon_type">속성</option>
		</c:otherwise>
		</c:choose>
	<input type="text" name= "keyword"  value="${keyword}">
	<button>검색</button>

</form>

<h2>데이터 개수 : ${list.size()}</h2>

<table border= "1">
	<thead>
  <tr>
    <th>No.</th>
    <th>이름</th>
    <th>속성</th>
    <th>메뉴</th>
  </tr>
  <tbody>
  
<c:forEach var="dto" items="${list}">
  <tr>
    <td>${dto.poketmonNo}</td>
    <td>${dto.poketmonName}</td>
    <td>${dto.poketmonType}</td>
    <td>
    	<a href= "detail?poketmonNo=${dto.poketmonNo}">상세</a>
    </td>
  </tr>
</c:forEach>
    
  </tbody>
</table>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>

<%-- 	<h3>${dto.poketmonName} / ${dto.poketmonType}</h3> --%>

    
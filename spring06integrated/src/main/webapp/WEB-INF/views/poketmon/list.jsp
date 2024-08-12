<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<style>
	.btn.btn-neutral {
		padding: 1px;
	}
</style>
<div class="container w-500 my-50">
	<div class="row center">
<h1>포켓몬 목록</h1>
	</div>
	<div class="row right">
		<a href="insert" class="btn btn-neutral">신규등록</a>
	</div>
	<div class="row center table">
<form acton= "list" method="get" autocomplete="off">
	<select class="field" name="column" >
		<option  value= "poketmon_name">포켓몬 이름</option>
		<c:choose>
			<c:when test= "${column == 'poketmon_type'}">
		<option value= "poketmon_type"selected>포켓몬 타입</option>
		</c:when>
		<c:otherwise>
			<option value= "poketmon_type">포켓몬 속성</option>
		</c:otherwise>
		</c:choose>
	<input class="field" type="text" name= "keyword"  value="${keyword}">
	<button type="summit" class="btn btn-positive"><i class="fa-solid fa-magnifying-glass"></i>검색</button>

</form>
	
	</div>
<div class="row">
데이터 개수 : ${list.size()}
</div>

<form action="deleteAll" method="post">
<c:if test= "${sessionScope.createdLevel == '관리자' }">
<div class="row right">
	<button type="submit" class="btn btn-negative">체크된 항목 삭제</button>
</div>
</c:if>
<div class="row">
<table class="table table-border table-hover">
	<thead></thead>
  <tr>
  <c:if test= "${sessionScope.createdLevel == '관리자' }">
  	<th>
  		<input type="checkbox" class="check-all">
  	</th>
  	</c:if>
    <th>No.</th>
    <th>이미지</th>
    <th>이름</th>
    <th>속성</th>
    <th>메뉴</th>
  </tr>
  <tbody>
  
<c:forEach var="dto" items="${list}">
  <tr>
  <c:if test= "${sessionScope.createdLevel == '관리자' }">
  	<td>
  		<input type="checkbox" class="check-item" name="poketmonNo" value="${dto.poketmonNo}">
  	</td>
  </c:if>
    <td>${dto.poketmonNo}</td>
    <td>
    	<img src= "image?poketmonNo=${dto.poketmonNo}" width= "16" height= "16">
    </td>
    <td>${dto.poketmonName}</td>
    <td>${dto.poketmonType}</td>
    <td>
    	<a class="btn btn-neutral" href= "detail?poketmonNo=${dto.poketmonNo}">상세</a>
    </td>
  </tr>
</c:forEach>
    
  </tbody>
</table>
</div>
<!-- 네비게이터 -->
<%-- 이전 버튼은 첫 번째 구간이 아닐 때(startBlock > 1) 나온다. --%>
<div class="pagination">
<c:if test="${pageVO.hasPrev()}">
<a href= "list?column=${pageVO.column}&keyword=${pageVO.keyword}&page=${pageVO.prevBlock}">이전</a> 
</c:if>
<%-- 
	startBlock부터 
	finishBlock과 lastBlock중 작은 값 까지
 	반복문으로 링크 출력 
--%>
<c:forEach var= "n" begin= "${pageVO.startBlock}" 
										end="${pageVO.finishBlock}" step="1">
	<c:choose>
		<c:when test= "${pageVO.page == n}">
			<a>${n}</a>
		</c:when>
		<c:otherwise>
			<a href="list?column=${pageVO.column}&keyword=${pageVO.keyword}&page=${n}">${n}</a>
		</c:otherwise>
	</c:choose>
</c:forEach>
<%--다음 버튼은 마지막 구간이 아닐 때(finishBlock < lastBlock) 나온다 --%>
<c:if test= "${pageVO.hasNext()}">
	<a href= "list?column=${pageVO.column}&keyword=${pageVO.keyword}&page=${pageVO.nextBlock}">다음</a></h3>
</c:if>
</div>
<%-- 비회원일 때와 회원일 때 다르게 보이도록 처리 --%>
<c:choose>
	<c:when test= "${sessionScope.createdUser != null}">
		<h2><a class="btn btn-neutral"  href= "/board/write">글쓰기</a></h2>
	</c:when>
	<c:otherwise>
		<h2><a title= "로그인 후 사용 가능합니다.">글쓰기</a></h2>
	</c:otherwise>
</c:choose>	
</form>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>

<%-- 	<h3>${dto.poketmonName} / ${dto.poketmonType}</h3> --%>

    
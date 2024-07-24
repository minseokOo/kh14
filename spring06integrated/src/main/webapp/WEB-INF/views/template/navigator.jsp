<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</div>
</c:if>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h1>프로그래밍이 첨가된 페이지</h1>
    
<%for(int i=0; i<10; i++){ %>
    <h2>Hello</h2>
<%} %>   

<%-- 
	JSTL을 이용하여 동일한 프로그래밍 처리 구현 
	- Jsp Standard Tag Library 줄여서 JSTL이라고 부름
	- HTML만으로 해결 되지 않는 프로그래밍 처리를 담당(if, switch, for, try)
	- 쓰고자 하는 페이지에 반드시 설정 코드를 작성해야함
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach begin= "1" end="10" step="1">
	<h2>안녕? ${i}</h2>
</c:forEach>




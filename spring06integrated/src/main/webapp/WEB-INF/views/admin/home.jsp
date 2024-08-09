<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
    
    <div class="container w-1100 my-50">
    <div class="row">
    <h1>관리자 페이지</h1>
    </div>
    
    <div class="row">
    <h2><a class="link link-animation" href= "/admin/member/list">회원검색</a></h2>
    </div>
	<div class="row">
    <h2><a class="link link-animation" href= "/admin/status">데이터현황</a></h2>
	</div>
    
    </div>
    
    <jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
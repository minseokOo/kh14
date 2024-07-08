<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

    <!-- 문서 설정 - HTML버전 지정 (HTML 5)-->
<!Doctype HTML>
<html><!-- HTML 문서의 범위를 나타내는 태그 -->
	<head> <!-- 문서의 정보를 표시하는 태그 -->
		<title>나의 홈페이지</title>
		<meta charset= "UTF-8">
	</head>
	<body> <!-- 문서의 출력 내용을 담는 태그 -->
<!-- 		<h1>내가 만든 홈페이지</h1> -->
<!-- 		<a href=""></a> -->
		<!-- 상단(Header) -->
		<div>
			<h1>내가 만든 홈페이지</h1>
		</div>
		
		<!-- 정보 확인용 공간 -->
		<div>
			session id = ${pageContext.session.id} , 
			createUser = ${sessionScope.createUser}
		</div>
		
		<!-- 
			메뉴(Navbar) 
			- (중요) 템플릿 페이지의 모든 경호는 전부 다 절대경로로 사용
			- 로그인 상태일 때와 비로그인 상태일 때 다르게 표시
			- 로그인 상태 : sessionScope.createdUser != null
			
			-->
		<div>
			<c:choose>
				<c:when test= "${sessionScope.createdUser != null}">
					<a href= "/">홈으로</a>
					<a href= "/poketmon/list">포켓몬스터</a>
					<a href= "/emp/list">사원정보</a>	
					<a href= "/book/list">도서정보</a>
					<a href= "/member/mypage">내정보</a>
					<a href= "#">게시판</a>
					<a href= "/member/logout">로그아웃</a>
				</c:when>
				<c:otherwise>
					<a href= "/">홈으로</a>
					<a href= "/poketmon/list">포켓몬스터</a>
					<a href= "/member/join">회원가입</a>
					<a href= "/member/login">로그인</a>
					<a href= "#">게시판</a>
				</c:otherwise>
			
			</c:choose>
		</div>
		<hr>
		<!-- 중단(Container) -->
		<div>
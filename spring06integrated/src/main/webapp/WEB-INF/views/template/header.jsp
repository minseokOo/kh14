<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
	<link rel="stylesheet" type="text/css" href="/css/commons.css">
 <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
<!-- 	<link rel="stylesheet" type="text/css" href="/css/test.css"> -->

    <!-- 문서 설정 - HTML버전 지정 (HTML 5)-->
<!Doctype HTML>
<html><!-- HTML 문서의 범위를 나타내는 태그 -->
	<head> <!-- 문서의 정보를 표시하는 태그 -->
		<title>나의 홈페이지</title>
		<meta charset= "UTF-8">
		
		<!-- 내가 만든 스타일 시트를 불러오는 코드 -->
	
	</head>
    <style>
        .btn.btn-neutral{
            background-color: rgb(187, 186, 255);
            color: rgb(0, 0, 131);
            border-radius: 3px;
            text-decoration-line: none;
        }
        .btn.btn-menu{
            background-color: rgb(187, 186, 255);
            color: rgb(0, 0, 131);
            border-radius: 3px;
            text-decoration-line: none;
            margin-top: 10px;
            padding : 0.5em 0.75em;
        }
	.link{
            color: #2d3436;
            text-decoration: none;
            display: inline-block;
        }
        .link.link-animation {
            /* transition : 항목 시간 타이밍 */
            transition: transform 0.5s ease-out;
        }
        .link.link-animation:hover {
           
            transform: rotate(360deg);
        }
    </style>

	<body bgcolor='#dff9fb'> <!-- 문서의 출력 내용을 담는 태그 -->
<!-- 		<h1>내가 만든 홈페이지</h1> -->
<!-- 		<a href=""></a> -->
		<!-- 상단(Header) -->
		<div class="center">
            <a href="/" class="link link-animation"><img src="/images/홈페이지.png" width="200px"></a>
		</div>
		<!-- 정보 확인용 공간 -->
<!-- 		<div> -->
<%-- 			session id = ${pageContext.session.id} ,  --%>
<%-- 			createdUser = ${sessionScope.createdUser} , --%>
<%-- 			createdLevel = ${sessionScope.createdLevel} --%>
<!-- 		</div> -->
		
		<!-- 
			메뉴(Navbar) 
			- (중요) 템플릿 페이지의 모든 경호는 전부 다 절대경로로 사용
			- 로그인 상태일 때와 비로그인 상태일 때 다르게 표시
			- 로그인 상태 : sessionScope.createdUser != null
			
			-->
		<div class="row center mt-10">
			<c:choose>
				<c:when test= "${sessionScope.createdUser != null}">
<!-- 					<a class="btn btn-menu" href= "/">홈으로</a> -->
					<a class="btn btn-menu" href= "/poketmon/list">포켓몬스터</a>
					<a class="btn btn-menu" href= "/emp/list">사원정보</a>	
					<a class="btn btn-menu" href= "/book/list">도서정보</a>
					<a class="btn btn-menu" href= "/member/mypage">내정보</a>
					<a class="btn btn-menu" href= "/board/list">게시판</a>
					<a class="btn btn-menu" href= "/member/logout">로그아웃</a>
					
					<c:if test= "${sessionScope.createdLevel == '관리자' }">
					<!-- 관리자 메뉴 -->
					<a class="btn btn-menu" href= "/admin/home">[관리메뉴]</a>
					</c:if>
				</c:when>
				
				<c:otherwise>
<!-- 					<a class="btn btn-menu" href= "/">홈으로</a> -->
					<a class="btn btn-menu" href= "/poketmon/list">포켓몬스터</a>
					<a class="btn btn-menu" href= "/member/join">회원가입</a>
					<a class="btn btn-menu" href= "/member/login">로그인</a>
					<a class="btn btn-menu" href= "/board/list">게시판</a>
				</c:otherwise>
			
			</c:choose>
		</div>
		</div>
		<hr>
		<!-- 중단(Container) -->
		<div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

    <!-- 문서 설정 - HTML버전 지정 (HTML 5)-->
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메인페이지</title>
    <link rel="stylesheet" type="text/css" href="/css/commons.css">
<!-- 	<link rel="stylesheet" type="text/css" href="./test.css"> -->
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css">
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
</head>
<body bgcolor='#dff9fb'>
    <!-- 홈페이지 크기를 결정하는 외부 영역(main) -->
    <div class="container w-1200 center">
            <a href="/" class="link link-animation"><img src="/images/홈페이지.png" width="200px"></a>
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
	</div>
        <div class="row my-0 flex-box" style="min-height: 400px;">
            <div class="w-200">
                <div class="row center">
                    <img src="/images/프로필사진.png" class="image image-circle image-lift" width="50%">
                </div>
                <div class="row center">${sessionScope.createdUser}(${sessionScope.createdLevel})</div>
                <div class="row center">5,000 point</div>
            </div>
            <hr>
            <div style="flex-grow: 1;">
            
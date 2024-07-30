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
	<link rel="stylesheet" type="text/css" href="/css/test.css">
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
            cursor: default;
        }
	.link{
            color: #2d3436;
            text-decoration: none;
            display: inline-block;
        }
        .link.home-animation {
            /* transition : 항목 시간 타이밍 */
            transition: transform 0.5s ease-out;
        }
        .link.home-animation:hover {
           
            transform: rotate(360deg);
        }
    </style>
</head>
<body bgcolor='#dff9fb' style="-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none">
    <!-- 홈페이지 크기를 결정하는 외부 영역(main) -->
    <div class="container w-1200 center">
    <div class="row">
            <a href="/" class="link home-animation"><img src="/images/홈페이지.png" width="200px"></a>
</div>
			<c:choose>
				<c:when test= "${sessionScope.createdUser != null}">
				<div class="row center">
            <ul class="menu flex-core">
                <li>
                            <a class="btn btn-menu" href= "#">포켓몬스터</a>
                    <ul>
                        <li>
                        <a href="/poketmon/list">포켓몬 리스트</a>
                        </li>
                        <li>
                            <a href= "/poketmon/insert">포켓몬추가</a>	
                        </li>
                    </ul>
                </li>
                <li>
                <a class="btn btn-menu" href= "#">사원정보</a>	
                <ul>
                        <li><a href="/emp/list">사원목록</a></li>
                        <li><a href="/emp/add">사원추가</a></li>
                    </ul>
                </li>
                <li>
                    <a class="btn btn-menu" href= "#">도서정보</a>
                    <ul>
                        <li><a href="/book/list">도서리스트</a></li>
                        <li><a href="/book/save">도서추가</a></li>
                    </ul>
                </li>
                <li>
                    <a class="btn btn-menu" href= "/member/mypage">내정보</a>
                </li>
                <li>
                    <a class="btn btn-menu" href= "/board/list">게시판</a>
                </li>
                <c:if test= "${sessionScope.createdLevel == '관리자' }">
                <li>
					<!-- 관리자 메뉴 -->
					<a class="btn btn-menu" href= "/admin/home">[관리메뉴]</a>
                </li>
					</c:if>
            </ul>
        </div>
<!-- 					<a class="btn btn-menu" href= "/">홈으로</a> -->
					
					
					
				</c:when>
				
				<c:otherwise>
				<div class="row center">
            <ul class="menu flex-core">
                <li>
                            <a class="btn btn-menu" href= "/poketmon/list">포켓몬스터</a>
                    <ul>
                        <li>
                        <a href="/poketmon/list">포켓몬 리스트</a>
                        </li>
                    </ul>
                </li>
                <li>
                <a class="btn btn-menu" href= "/member/join">회원가입</a>
                </li>
                <li>
                    <a class="btn btn-menu" href= "/member/login">로그인</a>
                </li>
                <li>
                   <a class="btn btn-menu" href= "/board/list">게시판</a>
                </li>
            </ul>
        </div>
<!-- 					<a class="btn btn-menu" href= "/">홈으로</a> -->
				</c:otherwise>
			
			</c:choose>
		</div>

	<c:choose>
				<c:when test= "${sessionScope.createdUser != null}">
				<label for="ck-sidebar" class="sidebar-toggle">
    <i class ="fa-solid fa-bars fa-2x"></i>
 </label>
    <input type="checkbox" id="ck-sidebar">
    <div class="sidebar">

        <div class="row my-0 flex-box" style="min-height: 400px;">
            <div class="w-200">
                <div class="row center" style="margin-top:200px">
                    <img src="image?memberId=memberDto.${sessionScope.createdUser}" class="image image-circle image-lift" width="50%">
                </div>
                <div class="row center">${sessionScope.createdUser}(${sessionScope.createdLevel})</div>
                <div class="row center">5,000 point</div>
                <div class="row center">
                <a class="link link-animation" href= "/member/logout">로그아웃</a>
                </div>
            </div>
    </div>
	</div>
    
            </c:when>
            </c:choose>
            <hr>
            <div style="flex-grow: 1;">
            
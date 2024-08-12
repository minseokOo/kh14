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
        .profile-wrapper {
        	position:relative;
        	width: 100px;
        	height: 100px;
/*         	overflow:hidden; */
        }
        .profile-wrapper > label {
        background-color: rgba(0, 0, 0, 0.3);
        position: absolute;
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        border-radius: 50%;
        justify-content: center;
        align-items: center;
        color: white;
        cursor:pointer;
        
        display: none;
        }
        .profile-wrapper:hover > label {
        display: flex;
        }
    </style>
    <!-- 자바스크립트 -->
    <!-- jquery cdn -->
     <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
     <!-- 내가 만든 jQuery 라이브러리-->
     <script src="/js/checkbox.js"></script>
    <script src="/js/confirm-link.js"></script>
    
    <script type="text/javascript">
    	// 이미지 선택 태그가 변경된 경우 사용자 이미지를 변경하도록 처리 (회원 전용)
    	$(function(){
    		$("#change-image").change(function(){
    			//this == 파일선택태그
    			console.log(this.files);
    			if(this.files.length == 0)return;// 파일을 선택하지 않았으면 중단
    			
    			//전송 데이터 준비
    			var form = new FormData();
    			form.append("attach", this.files[0]);
    			
    			//비동기 통신으로 파일 업로드
    			$.ajax({
    				processData:false,
    				contentType:false,
    				url:"/rest/member/profile",
    				method:"post",
    				data:form,
    				success:function(){
    					//프로필 이미지 주소를 재설정 한다.
    					//(문제) 브라우저 캐싱으로 인해서 주소가 같아 바뀐 이미지가 보이지 않음
    					//(해결) 주소에서 한글자라도 변화를 줘야함(의미없는 파라미터 생성)
    					
    					//자바스크립트에서 겹치지 않는 시리얼 번호를 생성하는 코드
    					var uuid = crypto.randomUUID();
    					
    					$(".user-image").attr("src", "")
    					.attr("src", "/member/myImage?uuid="+uuid);
    				},
    			});
    			
    		});
    	});
    </script>
    
</head>
<body bgcolor='#dff9fb' style="-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none">
    <!-- 홈페이지 크기를 결정하는 외부 영역(main) -->
    <div class="container w-1200 center">
    <div class="row">
            <a href="/" class="link home-animation"><img src="/images/노정현(2).png" width="200px"></a>
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
                <div class="row center flex-core" style="margin-top:200px">
                <div class="profile-wrapper">
                    <img src="/member/myImage" class="image image-circle image-lift user-image w-100" >
                    <input type="file" id="change-image" accept="image/*" style="display:none;">
                    <label for="change-image">변경하기</label>
                </div>
                
                
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
            
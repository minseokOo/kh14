<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--  
	a 태그 
	- Anchor 태그
	- 하이퍼링크 기능이 존재(옵션으로 설정)

-->

<h1>A 태그</h1>
<br><br>
<a href="https://www.google.com">구글로 이동</a>
<br><br>
<a href="https://www.naver.com">네이버로 이동</a>
<br><br>
<!-- (Q) 네이버에서 "kh정보교육원"을 검색한 결과로 이동하는 링크 구현 -->
<a href= "https://search.naver.com/search.naver?where=nexearch&sm=top_sug.pre&fbm=0&acr=5&acq=kh&qdt=0&ie=utf8&query=kh정보교육원">kh정보교육원 검색 결과</a>
<br><br>
<!-- 내가 가진 페이지로도 연결이 가능한가? -->

<!--  (Q) test01 예제 페이지로 연결하도록 링크 구현 -->

<!-- 맨 앞을 슬래시(/)로 시작하는 주소를 "절대경로"라고 부름 (경로가 애매할때) -->

<!-- <a href= "http://localhost:8080/test01"> test01 예제페이지</a> -->
<a href= "/test01"> test01 예제페이지</a>

<!-- 현재 위치(.)을 기준으로 계산한 주소를 "상대경로"라고 부름 (같은 위치에 존재할때)-->
<h1>
	<a href= "./test01"> test01 예제 보러가기</a>
</h1>


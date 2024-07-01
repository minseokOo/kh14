<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>Form 예제</h1>

<!-- 
	form 태그는 데이터를 전송 시킬 수 있는 묶음용 태그 
	- action : 이 폼이 전송될 목적지

-->

<form action="https://www.genie.co.kr/search/searchMain?">

	<!-- 
	input 태그는 사용자가 무언가를 입력할 수 있는 도구 
	- name : 전달할 값에 붙을 이름
	-->
	<input name= "query">

	<!--  button 태그는 폼을 전송 시키는 도구 -->
	<button>전송</button>

</form>
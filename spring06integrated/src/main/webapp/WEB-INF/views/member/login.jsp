<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<style>
	.container {
            width: 300px;
            margin: 50px auto;
        }

        /* 행 디자인 */
        .row {
            margin: 10px 0;
        }


        .field, .btn {
            width: 100%;
            font-size: 14px;
            padding: 0.5em;
            height: 40px;

        }
        .field{
            border-color: lightgray;
            border-width: 1px;
            border-style: solid;
            border-top: none;
            border-right: none;
            border-left: none;
            outline: none;
        }
        
        .btn.btn-positive {
            color: #000000;
            background-color: #74b9ff;
            color:#5080b1;
            border: none;
            border-radius: 5px;
            margin: 7px 0 7px 0;
        }
        .btn.btn-negative {
            box-sizing: border-box;
            width: 300px;
            height: 40px;
            color: gray;
            background-color: rgb(231, 231, 231);
            border: none;
            border-radius: 5px;
            margin: 7px 0 15px 0;
        }	
</style>
<form autocomplete="off" action="login" method="post">
    <div class="container">
        <div class="row center">
            <img src="/images/썬구리.png" width="200px">
        </div>
<div class="row center">
    <h1>로그인</h1>
</div>
        <div class="row center">
            <input class="field" type="text" name="memberId" required placeholder= "아이디">
        </div>
        <div class="row center">
            <input class="field" type="password" name="memberPw"  required placeholder="비밀번호">
        </div>
        <hr>
        <div class="row center">
            <button class="btn btn-positive w-100 center">로그인</button>
        </div>
        <div class="row">
        	<a href="findPw">비밀번호가 기억나지 않습니다.(임시 비밀번호 방식)</a>
        </div>
        <div class="row">
        	<a href="findPw2">비밀번호가 기억나지 않습니다.(링크 방식)</a>
        </div>
    </div>
    </form>
<%--error라는 이름의 파라미터가 있으면 오류 메세지를 출력 --%>
<c:if test= "{param.error != null}">
	<h3 style = "color:red">아이디 또는 비밀번호가 잘못되었습니다.</h3>
</c:if>
    
    
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
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
        <div class="row ">
        	<label>아이디</label>
        	
        	<%--
        	JSP에서는 EL을 이용하여 쿠키에 접근할 수 있다. 
        	key에 대한 접근은 ${cookie.쿠키명.name},
        	value에 대한 접근은 ${cookie.쿠키명.value}으로 접근 가능
        	
        	--%>
            <input class="field" type="text" name="memberId"  value="${cookie.saveId.value}">
        </div>
        <div class="row">
        	<label>비밀번호</label>
            <input class="field" type="password" name="memberPw" >
        </div>

		<%--
			쿠키를 이용한 아이디 저장하기 체크박스 구현
			- saveId라는 쿠키 유무에 따라 체크 상태가 달라야한다.
			- 로그인 시 아이디 저장하기에 체크를 했는지 여부를 백엔드에서 알 수 있어야 한다.
			- 즉, 체크박스 값도 전송이 되어야 한다. (name과 value를 부여)
		 --%>
		<div class="row">
			<label>
				<input type="checkbox" name="remember" 
					<c:if test="${cookie.saveId != null}">checked</c:if>>
				<span>아이디 저장하기</span>
			</label>
		</div>

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
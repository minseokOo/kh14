<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<style>
    .container{
        width: 300px;
    }
    
    [name=memberId]{
            background-image: url("images/user.png");
        }
        [name=memberPw]{
            background-image: url("images/password.png");
        }
</style>
<script type="text/javascript">
    function account() {
        var account = document.querySelector(".account");
        var rexId = /^[a-z0-9]{8,20}$/;
        var isValid = rexId.test(account.value);
        console.log(isValid);
        if(isValid){
            var answer = document.querySelector(".answer");
            answer.classList.remove("red");
            answer.classList.add("green");
            answer.textContent = "사용할 수 있는 아이디입니다.";
        }
        else{
            var answer = document.querySelector(".answer");
            answer.classList.remove("green");
            answer.classList.add("red");
            answer.textContent = "영어소문자, 0~9까지의 숫자 8~20글자를 입력하세요.";
        }
        }
        function password() {
        var password = document.querySelector(".password");
        var rexPw = /^(?=(.*?)[A-Z])(?=(.*?)[a-z])(?=(.*?)[0-9])(?=(.*?)[!@#$])[A-Za-z0-9!@#$]{8,16}$/;
        var isValid = rexPw.test(password.value);
        if(isValid){
            var answerPw = document.querySelector(".answerPw");
            answerPw.classList.remove("red");
            answerPw.classList.add("green");
            answerPw.textContent = "사용 가능한 비밀번호 입니다.";
        }
        else{
            var answerPw = document.querySelector(".answerPw");
            answerPw.classList.remove("green");
            answerPw.classList.add("red");
            answerPw.textContent = "비밀번호는 영어대소문자, 숫자, 특수문자를 반드시 포함한 8~16자로 작성하세요.";
        }
        }
        function checkPw() {
        var password = document.querySelector(".password").value;
        var checkPw = document.querySelector(".checkPw").value;
        var chePw = document.querySelector(".chePw");
        
        // var isValid = password === checkPw;
        if(password === checkPw){
            chePw.classList.remove("red");
            chePw.classList.add("green");
            chePw.textContent = "비밀번호가 일치합니다.";
        }
        else{
            chePw.classList.remove("green");
            chePw.classList.add("red");
            chePw.textContent = "비밀번호가 일치하지 않습니다.";
        }
        }
    </script>
<div class="container">    
    <h1>회원 가입 정보 입력</h1>

<form action= "join" method= "post" enctype= "multipart/form-data" autocomplete="off">
    <label>아이디<i class="fa-beat fa-solid fa-asterisk"></i></label>
    <div class="row">
    <input class="field field-image w-100" type= "text" name="memberId" onblur="account()" required>
	</div>
    <label>비밀번호<i class="fa-beat fa-solid fa-asterisk"></i></label>
    <div class="row">
    <input class="field field-image w-100" type="password" name= "memberPw" onblur="password()" required>
    </div>
    <label>비밀번호 확인</label>
    <div class="row">
    <input class="field w-100" type="password" name="checkPw" onblur="checkPw()" required>
    </div>
    <label>닉네임<i class="fa-beat fa-solid fa-asterisk"></i></label>
    <div class="row">
	<input class="field w-100" type= "text" name= "memberNickname" required>
	</div>
    <label>이메일<i class="fa-beat fa-solid fa-asterisk"></i></label>
    <div class="row">
    <input class="field w-100" type= "email" name= "memberEmail" required>
	</div>
    <label>생년월일</label>
    <div class="row">
        <input class="field w-100" type= "date" name= "memberBirth">
	</div>
    <label>연락처</label>
    <div class="row">
         <input class="field w-100" type= "tel" name= "memberContact">
    </div>
    <label>주소</label>
    <div class="row">
     
	<input class="field w-100" type= "text" name=memberPost size= "6" placeholder= "우편번호"> 
    </div>
    <label>상세주소</label>
    <div class="row">
	<input class="field w-100" type= "text" name=memberAddress1 size= "60" placeholder= "기본주소"> 
	<input class="field w-100" type= "text" name=memberAddress2 size= "60" placeholder= "상세주소"> 
    </div>
    <label>사진 등록</label>
    <div class="row">
	    <input type= "file" name= "attach"> 
    </div>
<!-- 	프로필 이미지 <input type= "file" name= "attach" accept= ".png"> <br><br> -->
<!-- 	프로필 이미지 <input type= "file" name= "attach" accept= ".png, .jpg"> <br><br> -->
<div class="row right">	
    <button class="btn btn-positive">가입하기</button>
</div>
</form>
</div>


<jsp:include page= "/WEB-INF/views/template/footer.jsp"></jsp:include>
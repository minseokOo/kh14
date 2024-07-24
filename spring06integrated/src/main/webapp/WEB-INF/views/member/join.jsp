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

<div class="container">    
    <h1>회원 가입 정보 입력</h1>

<form action= "join" method= "post" enctype= "multipart/form-data" autocomplete="off">
    <label>아이디*</label>
    <div class="row">
    <input class="field field-image w-100" type= "text" name="memberId" required>
	</div>
    <label>비밀번호*</label>
    <div class="row">
    <input class="field field-image w-100" type="password" name= "memberPw" required>
    </div>
    <label>닉네임*</label>
    <div class="row">
	<input class="field w-100" type= "text" name= "memberNickname" required>
	</div>
    <label>이메일*</label>
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
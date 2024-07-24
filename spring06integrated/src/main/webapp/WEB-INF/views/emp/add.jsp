<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
   <style>
        .btn.btn-positive{
            border: none;
            border-radius: 3px;
            background-color: rgb(113, 113, 255);
        }
        .btn.btn-neutral{
            border-radius: 3px;
            color: black;
        }
    </style>
    <div class="container left w-400">
    <h2>사원 정보 등록</h2>
    
    <form action= "./add" method="post" enctype= "multipart/form-data">
        <label>사진 등록</label>
        <div class="row left">
    <input class="field w-66" name= "attach" type= "file">
</div>
<label>사원 이름</label>
<div class="row left">
    <input class="field w-66" name= "empName" type="text" required autocomplete="off">
	</div>
    <label>소속 부서</label>
    <div class="row left">
	<select class="field w-66" name= "empDept"  required>
	<option value= "">선택하세요</option>
	<option value= "영업팀">영업팀</option>
  	<option value= "기획팀">기획팀</option>
  	<option value= "총무팀">총무팀</option>
  	<option value= "개발팀">개발팀</option>
  	<option value= "운영팀">운영팀</option>
	</select>
</div>
<label> 입사일</label>
<div class="row ">
  <input class="field w-66" name= "empDate"required type=date autocomplete='off'>
</div>
<label>직급</label>
<div class="row ">
  <select class="field w-66" name= "empRank" required>
  	<option value= "">선택하세요</option>
  	<option value= "인턴">인턴</option>
  	<option value= "사원">사원</option>
  	<option value= "주임">주임</option>
  	<option value= "대리">대리</option>
  	<option value= "과장">과장</option>
  	<option value= "부장">부장</option>
  	<option value= "이사">이사</option>
  	<option value= "사장">사장</option>
  </select>
</div>
<label>월급</label>
<div class="row"> 
  <input class="field w-66 left" name= "empSal"required type=number autocomplete='off' > 원
</div>
<div class="row center">
  <button class="btn btn-positive">등록</button>
</div>
  </form>
  
  <a class="btn btn-neutral" href= "http://localhost:8080/emp/list">사원 정보 리스트</a>
</div>
</body>
</html>
  
  <jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
  
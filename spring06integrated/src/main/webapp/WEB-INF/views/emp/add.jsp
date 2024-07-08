<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
    <h2>사원 정보 등록</h2>
    <br><br>
    <form action= "./add" method="post">
    사원 이름
    <input name= "empName" type="text" required autocomplete="off">
	<br>
	소속 부서
	<select name= "empDept"  required>
	<option value= "">선택하세요</option>
	<option value= "영업팀">영업팀</option>
  	<option value= "기획팀">기획팀</option>
  	<option value= "총무팀">총무팀</option>
  	<option value= "개발팀">개발팀</option>
  	<option value= "운영팀">운영팀</option>
	
	</select>
	<br>
  입사일
  <input name= "empDate"required type=date autocomplete='off'>
<br>
직급
  <select name= "empRank" required>
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
  <br>
  월급
  <input name= "empSal"required type=number autocomplete='off'>
  <button>등록</button>
  </form>
  
  <a href= "http://localhost:8080/emp/list"><button>사원 정보 리스트</button></a>
  
  <jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
  
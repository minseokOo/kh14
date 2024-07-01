<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h1>여러가지 데이터</h1>

<a href= "./poketmon/list?column=poketmon_type&keyword=%EC%A0%84%EA%B8%B0">전기 포켓몬 목록</a>
 <br><br>
 
   <a href= "./emp/list?column=emp_dept&keyword=%EA%B0%9C%EB%B0%9C">개발팀 사원 목록</a>

   
  <hr>
  
  <h2>포켓몬스터 검색</h2>
  <form action= "/poketmon/list">
  	<input name= "column">
  	<input name= "keyword">
  	<button>검색</button>
  </form> 
  
  <hr>
  
  <h2>사원 검색</h2>
  <form action= "/emp/list">
  <select name= "column">
  	<option value= "emp_name">사원명</option>
  	<option value= "emp_dept">부서명</option>
  	<option value= "emp_rank">직급</option>
  </select>
  <input name = "keyword">
  <button>검색</button>
  </form>
  
<!--   poketmon_no, poketmon_name, poketmon_type -->
  <h2>포켓몬 등록</h2>
  <form action= "/poketmon/insert">
  <input name= "poketmonName">
  <input name= "poketmonType">
  <button>등록</button>
  </form>
  
  <h2>사원 등록</h2>
  <form action= "/emp/add">
  이름
  <input name= "empName">

  <select name= "empDept">
  	<option value= "영업팀">영업팀</option>
  	<option value= "기획팀">기획팀</option>
  	<option value= "총무팀">총무팀</option>
  	<option value= "개발팀">개발팀</option>
  	<option value= "운영팀">운영팀</option>
  </select>
  <br>
  입사일
  <input name= "empDate">

  <select name= "empRank">
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
  <input name= "empSal">
  <button>등록</button>
  </form>
  
   
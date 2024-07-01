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
   
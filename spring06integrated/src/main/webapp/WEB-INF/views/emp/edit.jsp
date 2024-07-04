<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h1>사원 정보 변경</h1>
    <form action="edit" method="post">
    	<input type="number" name="empNo" ><br><br>
    	이름 <input type= "text" name= "empName"><br><br>
    	부서 <input type= "text" name= "empDept"><br><br>
    	입사일 <input type= "date" name= "empDate"><br><br>
    	직급 <input type= "text" name= "empRank"><br><br>
    	월급 <input type= "number" name= "empSal"><br><br>
    <button>수정</button>
    </form>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h1>수료일 계산기</h1>
    
    <form action= "/test03goodbye.jsp">
    	<input type="date" name="finish"">
    	<button>계산하기</button>
    </form>
    
    <h2>오늘 : ${now}</h2>
    <br><br>
    <h2>수료일 : ${lastDay}</h2>
    <br><br>
    <h2>남은 일수 : ${period.getYears()}년
    ${period.getMonths()}월
    ${period.getDays()}일 남았습니다.</h2>
    
    
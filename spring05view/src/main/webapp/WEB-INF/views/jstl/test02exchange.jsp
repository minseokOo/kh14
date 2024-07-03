<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h1>환율 계산기</h1>

	<%-- 
	JSP에서 컨트롤러가 전달한 값을 출력하도록 하는 형식을 EL이라 한다
	(Expression Language)
	 --%>    
    
   <h2>한화 : ${KRW}</h2>
   <br><br>
   <h2>달러 : ${USD}</h2>
   <br><br>
   <h2>위안 : ${CNY}</h2>
   <br><br>
   <h2>엔 : ${JPY}</h2>
   <h2>환전 가능 여부 : ${KRW >= 10000}</h2>
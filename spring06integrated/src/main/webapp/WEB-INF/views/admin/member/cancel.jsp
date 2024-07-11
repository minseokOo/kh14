<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
    <h1>차단 해제</h1>
    <form action= "cancel" method= "post">
    	<input type= "hidden" name= "blockTarget" value= "${param.blockTarget}">
    	<textarea type= "text" name= "blockMemo"  required placeholder= "사유 입력" 
    	 rows= "10" cols= "60"></textarea><br><br>
    	<button>해제</button>
    
    
    </form>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
    <h1>차단 해제</h1>
    <form action= "cancel" method= "post">
    	<input type= "hidden" name= "blockTarget" value= "${param.blockTarget}">
    	<input type= "text" name= "blockMemo"  required>
    	<button>해제</button>
    
    
    </form>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
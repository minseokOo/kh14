<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>글 작성</h2>

<form action= "./write"  method= "post">
<input type= "hidden" name= "boardWriter" value= "${createdUser}">
<table border= "1" width = "505">
	<thead>
		<tr>
			<th>제목</th>
			<td ><input size= "60" type= "text" name= "boardTitle" required></td>
		</tr>
	</thead>
	<tbody>
			<th colspan= "2">내용</th>
			<tr>
			<td colspan= "2"><textarea rows= "30" cols= "67" name= "boardContent" required></textarea></td>
			</tr>
		
	</tbody>
</table>


	
	<input type= "hidden" name= "boardViews" value= "0">
	<input type= "hidden" name= "boardLikes"  value= "0">
	<input type= "hidden" name= "boardReplies"  value= "0">
<button>등록</button>



</form><br><br>
<a href= "/board/list">목록으로</a>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
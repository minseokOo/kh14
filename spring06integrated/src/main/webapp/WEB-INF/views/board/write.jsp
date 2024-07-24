<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<style>
	.container{
		width: 600px;
	}
	.textarea.field {
            resize: vertical;
            min-height: 120px;
        }
    .btn.btn-positive{
    
    }
</style>


<div class="container center">
    <div class="row">
        <h2>글 작성</h2>
    </div>
<form action= "./write"  method= "post">

	<!-- (추가) 파라미터에 boardTarget이 있으면 답글이 되도록 정보 첨부 -->
	<c:if test="${param.boardTarget != null}">
		<input type="hidden" name= "boardTarget" value= "${param.boardTarget}">
	</c:if>





<input type= "hidden" name= "boardWriter" value= "${createdUser}">
<table border= "1" class="row w-100">
	<thead>
		<tr>
			<th><label>제목</label></th>
			<td ><input class="field w-100" type= "text" name= "boardTitle" required></td>
		</tr>
	</thead>
	<tbody>
			<th colspan= "2">내용</th>
			<tr>
			<td colspan= "2"><textarea class="field  w-100" rows= "30" cols= "67" name= "boardContent" required></textarea></td>
			</tr>
		
	</tbody>
</table>



	<input type= "hidden" name= "boardViews" value= "0">
	<input type= "hidden" name= "boardLikes"  value= "0">
	<input type= "hidden" name= "boardReplies"  value= "0">
<div class="row">
    <button class="btn btn-positive w-50 center">등록</button>
</div>
</form>

<div>
<a type="button" href= "/board/list">목록으로</a>
</div>
</div>
</body>
</html>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

 <!-- summernote cdn -->
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.20/dist/summernote-lite.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.20/dist/summernote-lite.min.js"></script>
   <!-- 자바스크립트 작성 영역 -->
  <script type="text/javascript">
    $(function () {
      // $(선택자).summernote({옵션객체});
      $("[name=boardContent]").summernote({
        minHeight: 250,
        maxHeight: 500,

        placeholder: "내용 입력",
        toolbar: [
          // [menu name, [list of button name]]
          ['area', ['style', 'undo', 'redo']],
          ['style', ['bold', 'italic', 'underline']],
          ['font', ['fontname', 'fontsize', 'forecolor', 'backcolor']],
          ['tool', ['ul', 'ol', 'table', 'hr', 'fullscreen']],
          ['height', ['height']]
        ]
      });
    });
  </script>
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
    .note-editable{
      background-color: white;
    }
    .note-editor{
    	border: 1px solid #636e72 !important;
    }
</style>


<div class="container w-800">
    <div class="row">
        <h2>글 작성</h2>
    </div>
<form action= "./write"  method= "post">

	<!-- (추가) 파라미터에 boardTarget이 있으면 답글이 되도록 정보 첨부 -->
	<c:if test="${param.boardTarget != null}">
		<input type="hidden" name= "boardTarget" value= "${param.boardTarget}">
	</c:if>





<input type= "hidden" name= "boardWriter" value= "${createdUser}">
<table border= "0" class="row w-100">
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
<div class="row right">
    <button class="btn btn-positive w-33 center">등록</button>
</div>
</form>

<div>
<a type="button" href= "/board/list">목록으로</a>
</div>
</div>
</body>
</html>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
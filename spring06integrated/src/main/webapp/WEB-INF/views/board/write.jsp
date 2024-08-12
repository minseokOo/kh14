<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

 <!-- summernote cdn -->
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.20/dist/summernote-lite.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.20/dist/summernote-lite.min.js"></script>
   <!-- 자바스크립트 작성 영역 -->
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
          ['area', ['style']],
          ['style', ['bold', 'italic', 'underline']],
          ['font', ['fontname', 'fontsize', 'forecolor', 'backcolor']],
          ['tool', ['ul', 'ol', 'table', 'hr', 'fullscreen']],
          ['height', ['height']],
          ['attach', ['picture']]
        ],
        // 콜백 설정
        callbacks: {
          onImageUpload: function (files) {
            console.log(files);
            //$summernote.summernote('insertNode', imgNode);
            //1. 파일 업로드는 원래 form에 post방식, multipart/form-data여야 한다.
            //2. 상황상 form을 쓸 수가 없다. (form은 게시글 등록에 사용)
            //3. ajax를 이용하여 파일을 업로드를 할 예정
            //4. ajax를 이용하여 Form으로 post방식, multipart 전송이 가능하도록 구현
            // ---------->서버로 파일 전송
            // <---------- 서버에서 다운로드 주소를 전송해줘야 함
            //5. img 태그를 생성해서 다운로드 주소를 설정
            //6. 에디터에 추가

            //*중요*
            //form이 없어도 FormData라는걸 쓰면 같은 효과 발생
            //.append(이름, 파일 또는 값)을 추가한다
            var form = new FormData();
            form.append("attach", files[0]);

            $.ajax({
              processData: false, /*파일업로드에 꼭 필요한 설정*/
              contentType: false, /*파일업로드에 꼭 필요한 설정*/
              url:"/rest/board/upload",
              method:"post",
              data: form,
              success:function(response){
                // response에는 파일번호가 있어야 한다.
                console.log(response);
                // 태그를 만들 때는 선택자에 온전한 태그를 넣는다.
                var tag = $("<img>").addClass("board-attach").attr("src", "/attach/download?attachmentNo=" + response);
                $("[name=boardContent]").summernote("insertNode", tag[0]);
              }
            });
          }
        },
      });
      if ($("[name=boardContent]").summernote("isEmpty")) {
        $("[name=boardContent]").summernote("code", "")
      }
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
			<td colspan= "2"><textarea class="field  w-100" rows= "30" cols= "67" name= "boardContent" required> </textarea></td>
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
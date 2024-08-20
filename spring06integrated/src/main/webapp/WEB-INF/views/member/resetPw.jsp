<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<div class="container w-600 my-50">
	<div class="row center">
		<h1>비밀번호 재설정</h1>
	</div>

	<form action="resetPw" method="post" autocomplete="off">
		<input type="hidden" name="certEmail" value="${certDto.certEmail}">
		<input type="hidden" name="certNumber" value="${certDto.certNumber}">
		<input type="hidden" name="memberId" value="${memberId}">
		
		<div class="row">
			<label>변경할 비밀번호</label>
			<input type="password" name="memberPw" class="field w-100">
		</div>
		<div class="row">
			<button type="submit" class="btn btn-positive w-100">
				변경하기
			</button>
		</div>
		
	</form>

</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
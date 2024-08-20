<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<!--    <a href="http://localhost:8080/poketmon/list"><button>포켓몬 리스트</button></a> -->
<!--   <br> -->
<style>
.btn.btn-positive {
	background-color: rgb(88, 104, 255);
	color: blue;
	border: none;
	border-radius: 3px;
	height: 35px;
}
</style>
<script type="text/javascript">
	var pmNameValid = false;
	var pnTypeValid = false;

	function pmName() {
		var pmName = document.querySelector(".pmName");
		var rexId = /^[가-힣\s]{1,10}$/;
		pmNameValid = rexId.test(pmName.value);
		pmName.classList.remove("success", "fail");
		pmName.classList.add(pmNameValid ? "success" : "fail");
	}
	function pmType() {
		var pmType = document.querySelector(".pmType");
		pmTypeValid = pmType.value.length > 0;
		pmType.classList.remove("success", "fail");
		pmType.classList.add(pmTypeValid ? "success" : "fail");
	}
	// function pmImage(){
	//     var pmImage = document.querySelector(".pmImage");
	//     console.log(pmImage);
	// }
	function checkForm() {
		return pmNameValid && pmTypeValid;
	}
</script>
<div class="container w-500">
	<h2>포켓몬 입력기</h2>
	<form action="insert" method="post" autocomplete="off"
		enctype="multipart/form-data" onsubmit="return checkForm();">
		<div class="row">
			<input type="hidden" name="poketmonNo" class="field"> <label>이름</label>
			<input type="text" name="poketmonName" class=" pmName field w-100"
				onblur="pmName()">
			<div class="success-feedback"></div>
			<div class="fail-feedback">한글 또는 숫자 10자 이하로 작성하세요.</div>
		</div>
		<div class="row">
			<label>속성</label> <input type="text" name="poketmonType"
				class=" pmType field w-100" onblur="pmType()">
			<div class="fail-feedback">속성을 입력해주세요.</div>
		</div>
		<div class="row">
			<label>이미지</label> <input type="file" name="attach"
				class="field w-100">
		</div>
		<button class="btn btn-positive w-100" type="submit">등록</button>
	</form>

</div>



<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
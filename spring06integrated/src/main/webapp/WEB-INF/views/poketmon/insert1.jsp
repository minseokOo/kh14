<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
   <h2>포켓몬 입력기</h2>
<!--    <a href="http://localhost:8080/poketmon/list"><button>포켓몬 리스트</button></a> -->
<!--   <br> -->
<style>
	.btn.btn-positive{
	 background-color: rgb(88, 104, 255);
     color: blue;
	border: none;
    border-radius: 3px;
    height: 35px;
    
	}
</style>
   <form action= "./insert" method="post" enctype="multipart/form-data">
   
    <div class="container w-400 my-50">
        <div class="row center"><h2>포켓몬 등록</h2></div>
        <div class="row">
            <label>몬스터 이름</label>
            <input type="text" name="poketmonName" class="field w-100" required autocomplete="off">
        </div>
        <div class="row">
            <label>몬스터 속성</label>
            <select name="poketmonType" class="field w-100">
                <option value="">선택</option>
                <option value="불">불</option>
                <option value="물">물</option>
                <option value="풀">풀</option>
                <option value="바람">바람</option>
                <option value="땅">땅</option>
            </select>
        </div>
        <div class="row">
            <label>몬스터 이미지</label>
            <input type="file" name="attach" accept="image/*" class="field w-100">
        </div>
        <div class="row mt-40">
            <button class="btn btn-positive w-100">등록하기</button>
        </div>
    </div>
   </form>
   
   <jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
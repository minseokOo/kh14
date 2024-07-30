<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- header.jsp에 존재하는 내용을 불러오도록 설정 -->
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<div class="container w-700" style="height=400">
		<div class="row center">
			<h1>홈페이지에 오신것을 환영합니다.</h1>
		</div>
<style>
.img-box {
  position: relative;
  width: 700px;
  height: 400px;
  overflow: hidden; 
  transition: transform 2s linear;
}

.img-box img {
  position: absolute;
  width: 100%;
  height: 100%;
  transition: transform 2s linear; 
  border-radius: 1em;
}

.img-box img.img-hover {
transition: 2s;
  opacity: 0;
}

.img-box:hover img.img {
  opacity: 0;
}

.img-box:hover img.img-hover {
transition: 2s;
  opacity: 1; 
}
	
</style>			
<div class="img-box">
  <img class="img" src="/images/qhshqhsh2.png" width="700"height="400" >
  <img class="img-hover" src="/images/썬구리.png" width="700" height="400">
</div>
</div>		
<!-- 			<img src="https://placehold.co/700x400"width="700"height="400"> -->
	
<!-- footer.jsp에 존재하는 내용을 불러오도록 설정 -->
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>

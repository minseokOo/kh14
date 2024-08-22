<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- header.jsp에 존재하는 내용을 불러오도록 설정 -->
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<div class="container w-1000" style="height=400">
		<div class="row center">
			<h1>홈페이지에 오신것을 환영합니다.</h1>
		</div>
<style>
	
        * {
    margin: 0;
    padding: 0;
}

:root{
    --index: calc(1vw + 1vh);
    --transition: cubic-bezier(.1, .7, 0, 1);
}


.wrapper{
    display: flex;
    align-items: center;
    justify-content: center;
    height: 100vh;
}

.items{
    display: flex;
    gap: 0.4rem;
    perspective: calc(var(--index) * 35);
}

.item{
    width: calc(var(--index) * 4);
    height: calc(var(--index) * 6);
    background-color: #222;
	background-size: cover;
    background-position: center;
    cursor: pointer;
    filter:brightness(.5);
    transition: transform 1.25s var(--transition), filter 3s var(--transition), width 1.25s var(--transition);
    will-change: transform, filter, rotateY, width;
    box-shadow: 10px 15px 10px black;
}

.item::before, .item::after{
    content: '';
    position: absolute;
    height: 100%;
    width: 20px;
    right: calc(var(--index) * -1);
}

.item::after{
    left: calc(var(--index) * -1);
}

.items .item:hover{
    filter: inherit;
    transform: translateZ(calc(var(--index) * 10));
}

/*Right*/

.items .item:hover + *{
    filter: inherit;
    transform: translateZ(calc(var(--index) * 8.5)) rotateY(35deg);
    z-index: -1;
}

.items .item:hover + * + *{
    filter: inherit;
    transform: translateZ(calc(var(--index) * 5.6)) rotateY(40deg);
    z-index: -2;
}

.items .item:hover + * + * + *{
    filter: inherit;
    transform: translateZ(calc(var(--index) * 2.5)) rotateY(30deg);
    z-index: -3;
}

.items .item:hover + * + * + * + *{
    filter: inherit;
    transform: translateZ(calc(var(--index) * .6)) rotateY(15deg);
    z-index: -4;
}


/*Left*/

.items .item:has( + :hover){
    filter: inherit;
    transform: translateZ(calc(var(--index) * 8.5)) rotateY(-35deg);
}

.items .item:has( + * + :hover){
    filter: inherit;
    transform: translateZ(calc(var(--index) * 5.6)) rotateY(-40deg);
}

.items .item:has( + * + * + :hover){
    filter: inherit;
    transform: translateZ(calc(var(--index) * 2.5)) rotateY(-30deg);
}

.items .item:has( + * + * + * + :hover){
    filter: inherit;
    transform: translateZ(calc(var(--index) * .6)) rotateY(-15deg);
}

.items .item:active, .items .item:focus {
	filter: inherit;
	z-index: 100;
	transform: translateZ(calc(var(--index) * 10));
    margin: 0 .45vw;
}
.items .item:focus {
    width: 90vw; /* 전체 화면 너비 */
    height: 50vh; /* 전체 화면 높이 */
    filter: inherit;
    transform: none; /* 확대/축소 없이 원래 상태로 */
    margin: 0; /* 마진 제거 */
    z-index: 9999; /* 다른 아이템들 위에 표시 */
}
    </style>	
		<c:if test="${isLongTimeNoSee}">
<style>
.modal{
		position:fixed;
		left: 50%;
		top: 50%;
		transform: translate(-50%, -50%);
		background-color: white;
		padding:20px;
		z-index: 99999;
	}

</style>	

<script type="text/javascript">
	$(function(){
		//모달 닫기 버튼 처리
		$(".modal-close-btn").click(function(e){
			e.preventDefault();//기본 이벤트 차단
			$(this).parents(".modal").remove();
		});
	});
</script>


<!-- 오랫만에 방문했을 경우 표시할 모달(modal)을 생성 -->
<div class="modal">
	<div class="container w-400">
		<div class="row center">
			<h1>왜 이렇게 오랜만에 왔어</h1>
		</div>
		<div class="row center">
			와줘서 고마워
		</div>
		<div class="row right">
			<a href="#" class="link link-animation modal-close-btn">닫기</a>
		</div>
	</div>
</div>
		</c:if>


<div class="row" style="height: 200px">

        <div class="row items flex-core">
          <div class="item" tabindex="0" style="background-image: url(images/qhshqhsh2.png)"></div>
          <div class="item" tabindex="0" style="background-image: url(images/당황.png)"></div>
          <div class="item" tabindex="0" style="background-image: url(images/번쩍.png)"></div>
          <div class="item" tabindex="0" style="background-image: url(images/서운.png)"></div>
          <div class="item" tabindex="0" style="background-image: url(images/썬구리.png)"></div>
          <div class="item" tabindex="0" style="background-image: url(images/우산.png)"></div>
          <div class="item" tabindex="0" style="background-image: url(images/웃음.png)"></div>
          <div class="item" tabindex="0" style="background-image: url(images/화남.png)"></div>
            
          </div>
          </div>
</div>		

<!-- 			<img src="https://placehold.co/700x400"width="700"height="400"> -->
	
<!-- footer.jsp에 존재하는 내용을 불러오도록 설정 -->
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>

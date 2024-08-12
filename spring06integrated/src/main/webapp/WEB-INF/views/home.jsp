<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
	width: 480px;
	height: 300px;
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
    
<div class="row center" style="height: 200px">
        <div class="items">
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

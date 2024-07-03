<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 
	표를 만드는 일반적인 방법
	1. 줄과 칸 수를 지정하여 만드는 방법
	2. 필요할 때 마다 줄 또는 칸을 추가하여 만드는 방법
	
	HTML은 2. 방식을 사용하며, 여러 개의 태그를 이용해 표를 구현
 -->

<h1>테이블 예제</h1>

<!-- 표 전체 영역을 <table>로 표시한다 -->
<table border="1">
	<thead> <!-- 표의 제목 영역을  <thead>로 표시한다-->
		<tr><!-- 표의 한 줄을 <tr>로 표시한다 -->
			<th><!-- 표의 한 칸을 <th>로 표시한다 -->
				번호
			</th>
			<th>이름</th>
			<th>속성</th>
		</tr>
	</thead>
	<tbody> <!--  표의 본문 영역을 <tbody>로 표시한다 -->
		<tr>
			<td align="center">1</td>
			<td align="center">이상해씨</td>
			<td align="center">풀</td>
		</tr>
		<tr>
			<td align="center">4</td>
			<td align="center">파이리</td>
			<td align="center">불꽃</td>
		</tr>
		<tr>
			<td align="center">25</td>
			<td align="center">피카츄</td>
			<td align="center">전기</td>
		</tr>
	</tbody>
	<tfoot> <!--  표의 하단 영역을 <tfoot>으로 표시한다 -->
	
	</tfoot>


</table>


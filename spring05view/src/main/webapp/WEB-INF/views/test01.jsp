<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- JSP 주석 - 사용자에게 보이지 않음 --%>
<!--  HTML 주석 - 사용자에게 보임 -->

<%--
	JSP (Java Server Page
	- 사용자가 볼 수 있는 화면을 제작해주는 페이지(레시피)
	- 최상단에 작성하는 설정을 디렉티브(Directive)라고 부른다.
	- JSP페이지를 만드는데 필요한 설정을 수행
	- 설정의 종류는 page / include / taglib 세 가지가 있다.
		- page 는 페이지 관련 설정
			1. language 는 이 페이지에서 사용 가능한 언어를 정의 (java 만 가능)
			2. contentType 은 사용자(브라우저)가 볼 페이지의 형태를 정의 (대분류/소분류 형태로 존재)
				- text/html 은 완성된 결과물의 형태를 말함(MIME-TYPE)
				- charset 은 완성된 결과물의 글자 인코딩 방식을 말함
					- ISO-8859-1 : 아스키코드
					- EUC-KR : MS949의 축소판(구 한글)
					- MS-949(CP-949) : MS에서 제정한 완성형 한글
					- UTF-8 : 유니코드(조합형+완성형)
			3. pageEncoding 은 JSP가 내부적으로 변환될 때 적용될 인코딩 방식
		- include 는 다른 페이지를 불러오는 설정
		- taglib 는 외부 라이브러리를 사용하기 위한 설정
	
	--%>
	
	
	<!-- 
		HTML(HyperText Markup Language)
		- 태그(tag)를 기반으로 문서를 만드는 방식의 언어
		- 시작 태그와 종료 태그로 구성(경우에 따라서는 종료 태그가 없을 수도 있음)
	 -->
	
<h1>
	<b>JSP</b>를 이용하여 <i>HTML</i> 페이지를 만들어봐요!
</h1>	
	
	
	
	
	
	
	

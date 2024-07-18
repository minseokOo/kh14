<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>파일 제어하기</h1>

<h2>포켓몬스터 정보와 파일 업로드</h2>
<form action= "upload1" method= "get">
	이름<input type= "text" name= "poketmonName"> <br><br>
	속성<input type= "text" name= "poketmonType"> <br><br>
	이미지 <input type= "file" name= "attach"> <br><br>
	<button>등록</button>
</form>	

	<h2>포켓몬스터 정보와 파일 업로드(POST)</h2>
<form action= "upload2" method= "post" >
	이름<input type= "text" name= "poketmonName"> <br><br>
	속성<input type= "text" name= "poketmonType"> <br><br>
	이미지 <input type= "file" name= "attach"> <br><br>
	<button>등록</button>
</form>

	<h2>포켓몬스터 정보와 파일 업로드(POST-multipart)</h2>
<form action= "upload3" method= "post" enctype="multipart/form-data">
	이름<input type= "text" name= "poketmonName"> <br><br>
	속성<input type= "text" name= "poketmonType"> <br><br>
	이미지 <input type= "file" name= "attach"> <br><br>
	<button>등록</button>
</form>
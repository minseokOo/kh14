<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h1>포켓몬스터 정보 변경</h1>
    
    <form action= "edit" method= "post">
    	번호 <input type="hidden" name= "poketmonNo"  value= "${dto.poketmonNo}"> <br><br>
    	이름 <input type="text" name= "poketmonName"  value= "${dto.poketmonName}"> <br><br>
    	속성 <input type="text" name= "poketmonType"  value= "${dto.poketmonType}"> <br><br>
    <button>수정</button>
    </form>
    
    
    
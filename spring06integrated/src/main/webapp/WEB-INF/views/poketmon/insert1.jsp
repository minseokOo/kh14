<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <h2>포켓몬 입력기</h2>
<!--    <a href="http://localhost:8080/poketmon/list"><button>포켓몬 리스트</button></a> -->
<!--   <br> -->
   
   <form action= "./insert" method="post">
   이름
   <input name= "poketmonName" type= "text" required autocomplete="off">
   타입
   <input name= "poketmonType" type= "text" required autocomplete="off">
   
   
   <button>등록</button>
   </form>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>도서 등록</h2>
    <form action="../book/save">
    도서명 <input name= "bookTitle" type= "text"  required 
    			placeholder= "(ex) 홍길동전" > <br><br>
   	지은이 <input name= "bookAuthor" type="text" required 
   				placeholder= "(ex) 피카츄"> <br><br>
   	출간일 <input name= "bookPublicationDate"	type= "date" required>
   	<br><br>	
    판매가 <input name="bookPrice" type="number" required value= "0"> <br><br>
    출판사 <input name= "bookPublisher" type= "text" required placeholder= "(ex) KH출판사">
    <br><br>
    페이지 수 <input name= "bookPageCount" type= "number" required>
    <br><br>
    장르 <select name= " bookGenre" required>
    <option value= "">선택하세요</option>
    <option value= "판타지">판타지</option>
    <option value= "소설">소설</option>
    <option value= "역사">역사</option>
    <option value= "과학">과학</option>
    <option value= "교양">교양</option>
    </select>
    
    <button>등록</button>
    </form>
    
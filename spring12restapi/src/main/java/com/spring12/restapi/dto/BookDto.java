package com.spring12.restapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Schema(description = "도서 정보 객체")
@Data
public class BookDto {
	
	@Schema(description = "도서 번호", example = "1")
	private int bookId;
	@Schema(description = "도서 제목", nullable = false, example = "자바신공", maxLength = 300)
	private String bookTitle;
	@Schema(description = "저자", nullable = true, example = "열혈강사", maxLength = 90)
	private String bookAuthor;
	@Schema(description = "출간일", nullable = true, example = "yyyy-MM-dd")
	private String bookPublicationDate;
	@Pattern(regexp = "^[0-9]+$")
	@Schema(description = "판매가", nullable = false)
	private int bookPrice;
	@Schema(description = "출판사", nullable = true, maxLength = 90)
	private String bookPublisher;
	@Schema(description = "페이지 수", nullable = false)
	private int bookPageCount;
	@Schema(description = "도서 장르", nullable = false, allowableValues = {"판타지", "소설", "역사", "과학", "교양"})
	private String bookGenre;
	
	
}

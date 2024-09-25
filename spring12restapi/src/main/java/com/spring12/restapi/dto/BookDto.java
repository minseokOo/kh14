package com.spring12.restapi.dto;

import lombok.Data;

@Data
public class BookDto {
	private int bookId;
	private String bookTitle;
	private String bookAuthor;
	private String bookPublicationDate;
	private int bookPrice;
	private String bookPublisher;
	private int bookPageCount;
	private String bookGenre;
	
	
}

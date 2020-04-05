package com.teamproject.gitsourcemerge.chat.vo;

import org.springframework.stereotype.Component;

@Component("bookVO")
public class BookVO {
	private String book_id, book_isBorrowed;
	
	public BookVO() {
		System.out.println("bookVO 호출");
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getBook_isBorrowed() {
		return book_isBorrowed;
	}

	public void setBook_isBorrowed(String book_isBorrowed) {
		this.book_isBorrowed = book_isBorrowed;
	}
	
	
}

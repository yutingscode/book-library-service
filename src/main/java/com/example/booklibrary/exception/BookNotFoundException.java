package com.example.booklibrary.exception;

public class BookNotFoundException extends RuntimeException {

	public BookNotFoundException(String isbn) {
	    super("Could not find book " + isbn);
	  }
	}

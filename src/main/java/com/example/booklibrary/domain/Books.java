package com.example.booklibrary.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="books")
public class Books {

	@Id
	@Column(name = "isbn")
	private  String isbn;
	
	@Column(name = "book_title")
	private String bookTitle;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "published_year")
	private int publishedYear;
	
	Books() {}
	
	public Books(String isbn, String bookTitle, String author, int publishedYear) {
		this.isbn = isbn; 
		this.bookTitle = bookTitle;
		this.author = author;
		this.publishedYear = publishedYear;
	}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPublishedYear() {
		return publishedYear;
	}

	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}
	
	@Override
	  public String toString() {
	    return "Book{" + "isbn=" + this.isbn + ","
	    		+ " bookTitle='" + this.bookTitle + '\'' 
	    		+ ", author='" + this.author 
	    		+ ", publishedYear='" + this.publishedYear
	    		+ '\'' + '}';
	  }

	@Override
	public int hashCode() {
		return Objects.hash(author, bookTitle, isbn, publishedYear);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Books other = (Books) obj;
		return Objects.equals(author, other.author) && Objects.equals(bookTitle, other.bookTitle)
				&& Objects.equals(isbn, other.isbn) && publishedYear == other.publishedYear;
	}
}

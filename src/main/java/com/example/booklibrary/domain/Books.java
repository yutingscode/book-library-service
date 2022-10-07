package com.example.booklibrary.domain;

import java.sql.Blob;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity
@Table(name="books")
public class Books {

	@Id
	@Column(name = "isbn")
	private String isbn;
	
	@Column(name = "book_title")
	private String bookTitle;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "published_year")
	private String publishedYear;
	
	@Lob
	@Column(name = "image")
	private String image;
	
	Books() {}
	
	public Books(String isbn, String bookTitle, String author, String publishedYear, String image) {
		this.isbn = isbn; 
		this.bookTitle = bookTitle;
		this.author = author;
		this.publishedYear = publishedYear;
		this.image = image;
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

	public String getPublishedYear() {
		return publishedYear;
	}

	public void setPublishedYear(String publishedYear) {
		this.publishedYear = publishedYear;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	@Override
	public String toString() {
		return "Books [isbn=" + isbn + ", bookTitle=" + bookTitle + ", author=" + author + ", publishedYear="
				+ publishedYear + ", image=" + image + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, bookTitle, image, isbn, publishedYear);
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
				&& Objects.equals(image, other.image) && Objects.equals(isbn, other.isbn)
				&& Objects.equals(publishedYear, other.publishedYear);
	}
}

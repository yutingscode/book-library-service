package com.example.booklibrary.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.booklibrary.exception.BookNotFoundException;
import com.example.booklibrary.*;
import com.example.booklibrary.domain.Books;
import com.example.booklibrary.repository.BooksRepository;

@RestController
public class BooksController {

	  private BooksRepository repository = null;
	  private final BooksModelAssembler assembler;

	  BooksController(BooksRepository repository, BooksModelAssembler assembler) {
		    this.repository = repository;
		    this.assembler = assembler;
		  }
  
	  @GetMapping("/books")
	  public CollectionModel<EntityModel<Books>> all() {
		  List<EntityModel<Books>> books = repository.findAll().stream()
		      .map(assembler::toModel)
		      .collect(Collectors.toList());

		  return CollectionModel.of(books, linkTo(methodOn(BooksController.class).all()).withSelfRel());
		}
	  
	  @PostMapping("/books")
	  public EntityModel<Books> newBook(@RequestBody Books newBook) {
	    return assembler.toModel(repository.save(newBook));
	  }
	  
	  @GetMapping("/books/{isbn}")
	  public EntityModel<Books> one(@PathVariable String isbn) {

	    Books book = repository.findById(isbn) //
	        .orElseThrow(() -> new BookNotFoundException(isbn));

	    return assembler.toModel(book);
	  }
	  
	  @PutMapping("/books/{isbn}")
	  public EntityModel<Books> replaceBook(@RequestBody Books newBook, @PathVariable String isbn) {
	    
	    Books updatedBook = repository.findById(isbn)
	      .map(book -> {
	    	  book.setBookTitle(newBook.getBookTitle());
	    	  book.setAuthor(newBook.getAuthor());
	    	  book.setPublishedYear(newBook.getPublishedYear());
	    	  book.setImage(newBook.getImage());
	        return repository.save(book);
	      })
	      .orElseGet(() -> {
	    	  newBook.setIsbn(isbn);
	        return repository.save(newBook);
	      });
	    
	    return assembler.toModel(updatedBook);
	 }

	  @DeleteMapping("/books/{isbn}")
	  ResponseEntity<?> deleteBook(@PathVariable String isbn) {
	    repository.deleteById(isbn);
	    return ResponseEntity.noContent().build();
	  }
}

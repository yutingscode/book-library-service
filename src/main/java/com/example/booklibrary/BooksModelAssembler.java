package com.example.booklibrary;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.example.booklibrary.controller.BooksController;

@Component
public class BooksModelAssembler implements RepresentationModelAssembler<Books, EntityModel<Books>> {

  @Override
  public EntityModel<Books> toModel(Books book) {
    return EntityModel.of(book, //
        linkTo(methodOn(BooksController.class).one(book.getIsbn())).withSelfRel(),
        linkTo(methodOn(BooksController.class).all()).withRel("books"));
  }
}
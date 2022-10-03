package com.example.booklibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.booklibrary.domain.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, String> {

}

package com.example.booklibrary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.booklibrary.repository.BooksRepository;

@Configuration
public class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(BooksRepository booksRepository) {

    return args -> {
      log.info("Preloading " + booksRepository.save(new Books("1843441306", "The Great Gatsby", "Harper Lee", 1925)));
      log.info("Preloading " + booksRepository.save(new Books("0446310786", "To Kill a Mockingbird", "F. Scott Fitzgerald", 1960)));
      booksRepository.findAll().forEach(book -> log.info("Preloaded " + book));
    };
  }
}
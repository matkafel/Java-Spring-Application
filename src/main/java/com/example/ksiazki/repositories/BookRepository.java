package com.example.ksiazki.repositories;

import com.example.ksiazki.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}

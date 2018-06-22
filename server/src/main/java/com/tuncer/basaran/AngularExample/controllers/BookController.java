package com.tuncer.basaran.AngularExample.controllers;

import com.tuncer.basaran.AngularExample.domains.Book;
import com.tuncer.basaran.AngularExample.repositories.BookRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by tuncer on 22/06/2018.
 */
@RestController
class BookController {
    private BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/books")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Book> books() {
        return repository.findAll().stream()
                .collect(Collectors.toList());
    }
}

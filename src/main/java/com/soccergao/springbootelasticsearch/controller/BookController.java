package com.soccergao.springbootelasticsearch.controller;

import com.soccergao.springbootelasticsearch.entity.Book;
import com.soccergao.springbootelasticsearch.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
    private BookRepository bookRepository;
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody Book book) {
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> findById(@PathVariable("id") String id) {
        Optional<Book> book = bookRepository.findById(id);
        return ResponseEntity.ok(book);
    }

    @GetMapping
    public ResponseEntity<List<Book>> findByNameAndPrice(@RequestParam("name") String name,
                                                   @RequestParam(name = "price", required = false) Integer price) {
        List<Book> book = Objects.isNull(price) ?
                bookRepository.findByName(name) :
                bookRepository.findByNameAndPrice(name, price);
        return ResponseEntity.ok(book);
    }
}

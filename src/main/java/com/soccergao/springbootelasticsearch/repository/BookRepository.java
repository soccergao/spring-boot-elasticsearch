package com.soccergao.springbootelasticsearch.repository;

import com.soccergao.springbootelasticsearch.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book, String> {
    List<Book> findByName(String name);
    List<Book> findByNameAndPrice(String name, Integer price);
}

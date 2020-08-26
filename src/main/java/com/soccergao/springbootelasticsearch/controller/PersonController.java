package com.soccergao.springbootelasticsearch.controller;

import com.soccergao.springbootelasticsearch.entity.Person;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    private ElasticsearchOperations elasticsearchOperations;

    IndexCoordinates indexCoordinates = IndexCoordinates.of("person");

    public PersonController(ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }

    @PostMapping
    public String save(@RequestBody Person person) {
        IndexQuery indexQuery = new IndexQueryBuilder()
                .withId(person.getId())
                .withObject(person)
                .build();
        String documentId = elasticsearchOperations.index(indexQuery, indexCoordinates);
        return documentId;
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") String id) {
        Person person = elasticsearchOperations.get(id, Person.class, indexCoordinates);
        return person;
    }
}
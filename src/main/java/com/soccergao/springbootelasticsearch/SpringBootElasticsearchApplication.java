package com.soccergao.springbootelasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.config.EnableElasticsearchAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.stream.Stream;

@SpringBootApplication
@EnableElasticsearchAuditing
public class SpringBootElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootElasticsearchApplication.class, args);
    }

}

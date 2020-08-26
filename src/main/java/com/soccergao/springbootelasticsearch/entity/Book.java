package com.soccergao.springbootelasticsearch.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;

@Data
@Document(indexName="books")
public class Book implements Persistable<String> {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String summary;

    @Field(type = FieldType.Integer)
    private Integer price;

    @CreatedDate
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern ="yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;

    @CreatedBy
    @Field(type = FieldType.Text)
    private String createdBy;

    @Override
    public boolean isNew() {
        return id == null || (createdDate == null && createdBy == null);
    }
}
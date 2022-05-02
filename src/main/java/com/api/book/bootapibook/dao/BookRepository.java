package com.api.book.bootapibook.dao;

import com.api.book.bootapibook.entities.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Integer>{
    public Book findById(int id);
}

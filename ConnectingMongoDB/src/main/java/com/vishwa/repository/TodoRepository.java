package com.vishwa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.vishwa.entities.Todo;

public interface TodoRepository extends Repository<Todo, String> {
    void delete(Todo delete) ;
    List<Todo> findAll() ;
    Optional<Todo> findOne(String id);
    Todo save(Todo saved);
}

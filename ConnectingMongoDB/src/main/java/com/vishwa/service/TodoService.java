package com.vishwa.service;

import java.util.List;

public interface TodoService {
   TodoDTO create(TodoDTO todo);
   TodoDTO delete(String id);
   List<TodoDTO> findAll();
   TodoDTO findById(String id);
   TodoDTO update(TodoDTO todo);
}

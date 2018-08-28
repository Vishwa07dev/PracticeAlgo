package com.vishwa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vishwa.entities.Todo;
import com.vishwa.repository.TodoRepository;

@Service
public class MongoDBTodoService implements TodoService {
    private final TodoRepository repository ;
	
	@Autowired
	public MongoDBTodoService(TodoRepository repository) {
		this.repository = repository ;
	}
	
	@Override
	public TodoDTO create(TodoDTO todo) {
		Todo persisted = Todo.getBuilder().title(todo.getTitle()).description(todo.getDescription()).build() ;
		persisted = repository.save(persisted);
		return convertToDTO(persisted);
	}

	@Override
	public TodoDTO delete(String id) {
		return null;
	}

	@Override
	public List<TodoDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TodoDTO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TodoDTO update(TodoDTO todo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Todo findTodoById(String id) throws Exception{
		Optional<Todo> result = repository.findOne(id);
		return result.orElseThrow(() -> new Exception());
	}
	
	private TodoDTO convertToDTO(Todo model){
		TodoDTO dto =  new TodoDTO() ;
		dto.setId(model.getId());
		dto.setDescription(model.getDescription());
		dto.setTitle(model.getTitle());
		return dto ;
	}
    
	
	

}

package com.paperpigeon.mongo_services;

/**
 * Created by dani on 2/7/17.
 */
import com.paperpigeon.dto.TodoDTO;
import com.paperpigeon.repositories.TodoRepository;
import com.paperpigeon.services.TodoService;
import com.paperpigeon.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public final class MongoTodoService implements TodoService {

    private final TodoRepository repository;

    @Autowired
    public MongoTodoService(TodoRepository repository) {
        this.repository = repository;
    }

    @Override
    public TodoDTO create(TodoDTO todo) {
        Todo persisted = Todo.getBuilder()
                .title(todo.getTitle())
                .description(todo.getDescription())
                .build();
        persisted = repository.save(persisted);
        return convertToDTO(persisted);
    }

    @Override
    public TodoDTO delete(String id) {
        Todo deleted = findTodoById(id);
        repository.delete(deleted);
        return convertToDTO(deleted);
    }

    @Override
    public List<TodoDTO> findAll() {
        List<Todo> todoEntries = repository.findAll();
        return convertToDTOs(todoEntries);
    }

    private List<TodoDTO> convertToDTOs(List<Todo> models) {
        return models.stream()
                .map(this::convertToDTO)
                .collect(toList());
    }

    @Override
    public TodoDTO findById(String id) {
        Todo found = findTodoById(id);
        return convertToDTO(found);
    }

    @Override
    public TodoDTO update(TodoDTO todo) {
        Todo updated = findTodoById(todo.getId());
        updated.update(todo.getTitle(), todo.getDescription());
        updated = repository.save(updated);
        return convertToDTO(updated);
    }

    private Todo findTodoById(String id) {
        Optional<Todo> result = repository.findOne(id);
        return result.orElseThrow(() -> new NullPointerException(id));

    }

    public void magic(String id){
        Todo todo = findTodoById(id);
        System.out.println(todo + "-----*******-----" + todo.getTitle());
        //System.out.println(id);
        todo.magic();
        todo = repository.save(todo);
        //return new TodoDTO();//convertToDTO(todo);
    }

    private TodoDTO convertToDTO(Todo model) {
        TodoDTO dto = new TodoDTO();

        dto.setId(model.getId());
        dto.setTitle(model.getTitle());
        dto.setDescription(model.getDescription());

        return dto;
    }
}
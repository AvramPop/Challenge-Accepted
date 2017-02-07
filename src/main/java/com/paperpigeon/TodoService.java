package com.paperpigeon;

/**
 * Created by dani on 2/7/17.
 */
import java.util.List;

interface TodoService {

    TodoDTO create(TodoDTO todo);

    TodoDTO delete(String id);

    List<TodoDTO> findAll();

    TodoDTO findById(String id);

    TodoDTO update(TodoDTO todo);
}

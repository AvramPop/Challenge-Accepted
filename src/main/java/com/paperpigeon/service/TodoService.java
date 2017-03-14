package com.paperpigeon.service;


import com.paperpigeon.dto.TodoDTO;

import java.util.List;

/**
 * Here are the methods of Todo that can be called via Rest.
 * If you want to add a new method, add it here, because the
 * DB service implements this interface.
 */

public interface TodoService {

    TodoDTO create(TodoDTO todo);

    TodoDTO delete(String id);

    List<TodoDTO> findAll();

    TodoDTO findById(String id);

    TodoDTO update(TodoDTO todo);

    TodoDTO magic(String id);
}

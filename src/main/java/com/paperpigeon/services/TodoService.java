package com.paperpigeon.services;

/**
 * Created by dani on 2/7/17.
 */
import com.paperpigeon.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    TodoDTO create(TodoDTO todo);

    TodoDTO delete(String id);

    List<TodoDTO> findAll();

    TodoDTO findById(String id);

    TodoDTO update(TodoDTO todo);

    void magic(String id);
}

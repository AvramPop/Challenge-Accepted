package com.paperpigeon.service;


import com.paperpigeon.dto.TodoDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Here are the methods of Todo that can be called via Rest.
 * If you want to add a new method, add it here, because the
 * DB service implements this interface.
 */
@Service
public interface TodoService {

    TodoDTO create(TodoDTO todo);

    TodoDTO delete(String id);

    //annotatia asta da dreptul doar celui care se afla in grupul dat in link sa faca call. aici ii pus cel de admin
   //@PreAuthorize("hasAuthority('https://api.stormpath.com/v1/groups/5f46JL3cvieUFlAgBhhjsy')")
    List<TodoDTO> findAll();

    TodoDTO findById(String id);

    TodoDTO update(TodoDTO todo);

    TodoDTO magic(String id);
}

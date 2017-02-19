package com.paperpigeon.repositories;


import com.paperpigeon.models.Todo;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;
/**
 * Here are the operations linked to the repo,
 * they are probably the same for every object
 */

public interface TodoRepository extends Repository<Todo, String> {

    void delete(Todo deleted);

    List<Todo> findAll();

    Optional<Todo> findOne(String id);

    Todo save(Todo saved);
}

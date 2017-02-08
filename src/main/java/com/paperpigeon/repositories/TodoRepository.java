package com.paperpigeon.repositories;

/**
 * Created by dani on 2/7/17.
 */
import com.paperpigeon.models.Todo;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

 public interface TodoRepository extends Repository<Todo, String> {

    void delete(Todo deleted);

    List<Todo> findAll();

    Optional<Todo> findOne(String id);

    Todo save(Todo saved);
}

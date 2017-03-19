package com.paperpigeon.repository;

import com.paperpigeon.model.Todo;
import com.paperpigeon.model.User;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Huzdu on 3/14/2017.
 */
public interface UserRepository extends Repository<User, String> {
    void delete(User deleted);

    List<Todo> findAll();

    Optional<User> findOne(String id);

    User save(User saved);
}

package com.paperpigeon.repository;


import com.paperpigeon.model.Todo;
import com.paperpigeon.model.User;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;
/**
 * Here are the operations linked to the repo,
 * they are probably the same for every object
 */

public interface UserRepository extends Repository<User, String> {

    void delete(User deleted);

    List<User> findAll();

    Optional<User> findOne(String id);

    User save(User saved);
}
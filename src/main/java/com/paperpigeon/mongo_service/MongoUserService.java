package com.paperpigeon.mongo_service;

import com.paperpigeon.dto.UserDTO;
import com.paperpigeon.repository.UserRepository;
import com.paperpigeon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Huzdu on 3/14/2017.
 */
public class MongoUserService implements UserService {

    private final UserRepository repository;

    @Autowired
    public MongoUserService (UserRepository userRepository){
        this.repository = userRepository;
    }

    @Override
    public UserDTO create(UserDTO dto) {
        return null;
    }

    @Override
    public UserDTO delete(String id) {
        return null;
    }

    @Override
    public List<UserDTO> findAll() {
        return null;
    }

    @Override
    public UserDTO findById(String id) {
        return null;
    }

    @Override
    public UserDTO update(UserDTO todo) {
        return null;
    }

    @Override
    public UserDTO magic(String id) {
        return null;
    }
}

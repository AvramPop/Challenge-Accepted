package com.paperpigeon.mongo_service;

import com.paperpigeon.dto.UserDTO;
import com.paperpigeon.repository.UserRepository;
import com.paperpigeon.service.UserService;
import com.paperpigeon.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * This is the place where we implement the methods from the controller(here, UserController)
 * the way they behave and connect to the DB
 * <p>!NEVER forget to save your changes in the DB (obj = repository.save(obj))!!</p>
 */

@Service
public final class MongoUserService implements UserService {

    private final UserRepository repository;

    @Autowired
    public MongoUserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDTO create(UserDTO user) {
        User persisted = User.getBuilder()
                .password(user.getPassword())
                .email(user.getEmail())
                .build();
        persisted = repository.save(persisted);
        return convertToDTO(persisted);
    }

    @Override
    public UserDTO delete(String id) {
        User deleted = findUserById(id);
        repository.delete(deleted);
        return convertToDTO(deleted);
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> userEntries = repository.findAll();
        return convertToDTOs(userEntries);
    }

    private List<UserDTO> convertToDTOs(List<User> models) {
        return models.stream()
                .map(this::convertToDTO)
                .collect(toList());
    }

    @Override
    public UserDTO findById(String id) {
        User found = findUserById(id);
        return convertToDTO(found);
    }

    @Override
    public UserDTO update(UserDTO user) {
        User updated = findUserById(user.getId());
        updated.update(user.getEmail(), user.getPassword());
        updated = repository.save(updated);
        return convertToDTO(updated);
    }

    private User findUserById(String id) {
        Optional<User> result = repository.findOne(id);
        return result.orElseThrow(() -> new NullPointerException(id));

    }

    private UserDTO convertToDTO(User model) {
        UserDTO dto = new UserDTO();


        dto.setPassword(model.getPassword());
        dto.setEmail(model.getEmail());
        dto.setId(model.getId());
        return dto;
    }
}
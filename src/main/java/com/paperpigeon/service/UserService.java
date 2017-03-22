package com.paperpigeon.service;


import com.paperpigeon.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Here are the methods of User that can be called via Rest.
 * If you want to add a new method, add it here, because the
 * DB service implements this interface.
 */

public interface UserService {

    UserDTO create(UserDTO card);

    UserDTO delete(String id);

    List<UserDTO> findAll();

    UserDTO findById(String id);

    UserDTO update(UserDTO card);
}
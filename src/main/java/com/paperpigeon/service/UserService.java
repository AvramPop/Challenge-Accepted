package com.paperpigeon.service;

import com.paperpigeon.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Huzdu on 3/14/2017.
 */
@Service
public interface UserService {

    UserDTO create(UserDTO dto);

    UserDTO delete(String id);

    List<UserDTO> findAll();

    UserDTO findById(String id);

    UserDTO update(UserDTO todo);

    UserDTO magic(String id);

}

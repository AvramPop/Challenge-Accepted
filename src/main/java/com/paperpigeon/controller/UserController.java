package com.paperpigeon.controller;

import com.paperpigeon.dto.UserDTO;
import com.paperpigeon.exception.TodoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Huzdu on 3/14/2017.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserController service;

    @Autowired
    public UserController(UserController service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    UserDTO create(@RequestBody @Valid UserDTO userEntry){
        return service.create(userEntry);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    UserDTO delete(@RequestBody @Valid UserDTO request) {
        return service.delete(request.findUserById(request.getId()));
    }

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    List<UserDTO> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/findone/{id}", method = RequestMethod.GET)
    UserDTO findById(@PathVariable String id) {
        return service.findById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    UserDTO update(@RequestBody @Valid UserDTO userEntry) {
        return service.update(userEntry);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(TodoNotFoundException ex) {
        ex.printStackTrace();
    }
}

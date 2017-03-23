package com.paperpigeon.controller;

import com.paperpigeon.dto.UserDTO;
import com.paperpigeon.exception.ObjectAlreadyInDB;
import com.paperpigeon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * This is the place where the whole magic happens. Here we create new REST calls
 * (GET, POST, etc), that can be than handled from outside (frontend, postman).
 */

@RestController
@RequestMapping("/api/user")
public final class UserController {

    private final UserService service;

    @Autowired
    UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    UserDTO create(@RequestBody @Valid UserDTO userEntry) {
        try {
            return service.create(userEntry);
        } catch (ObjectAlreadyInDB e) {
            System.out.println((e.getMessage()));
        }
        return null;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    UserDTO delete(@RequestBody @Valid UserDTO request) {
        return service.delete(request.getId());
    }

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    ModelAndView findAll() {
      //  return service.findAll();
        ModelAndView result = new ModelAndView("user/list");
        result.addObject("users", service.findAll());
        return result;
    }

    @RequestMapping(value = "/findone/{id}", method = RequestMethod.GET)
    UserDTO findById(@PathVariable String id) {
        return service.findById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    UserDTO update(@RequestBody @Valid UserDTO userEntry) {
        return service.update(userEntry);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    boolean login(@RequestBody @Valid UserDTO userEntry) {
        return service.login(userEntry);
    }
}
package com.paperpigeon.controller;

import com.paperpigeon.dto.TodoDTO;
import com.paperpigeon.exception.TodoNotFoundException;
import com.paperpigeon.service.TodoService;
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
@RequestMapping("/api/todo")
public final class TodoController {

    private final TodoService service;

    @Autowired
    TodoController(TodoService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    TodoDTO create(@RequestBody @Valid TodoDTO todoEntry) {
        return service.create(todoEntry);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    TodoDTO delete(@RequestBody @Valid TodoDTO request) {
        return service.delete(request.getId());
    }

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    ModelAndView findAll() {
        ModelAndView result = new ModelAndView("user/list");
        result.addObject("users", service.findAll());
        return result;
    }

    @RequestMapping(value = "/findone/{id}", method = RequestMethod.GET)
    TodoDTO findById(@PathVariable String id) {
        return service.findById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    TodoDTO update(@RequestBody @Valid TodoDTO todoEntry) {
        return service.update(todoEntry);
    }

    @RequestMapping(value = "/magic", method = RequestMethod.PUT)
    TodoDTO magic(@RequestBody @Valid TodoDTO request){
        return service.magic(request.getId());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(TodoNotFoundException ex) {
        ex.printStackTrace();
    }
}
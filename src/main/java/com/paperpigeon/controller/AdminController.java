package com.paperpigeon.controller;

import com.paperpigeon.dto.AdminDTO;
import com.paperpigeon.exception.TodoNotFoundException;
import com.paperpigeon.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Laura on 3/18/2017.
 */
@RestController
@RequestMapping("/api/admin")
public final class AdminController {
    private final AdminService service;

    @Autowired
    AdminController(AdminService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    AdminDTO create(@RequestBody @Valid AdminDTO adminEntry) {
        return service.create(adminEntry);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    AdminDTO delete(@RequestBody @Valid AdminDTO request) {
        return service.delete(request.getId());
    }

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    List<AdminDTO> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/findone/{id}", method = RequestMethod.GET)
    AdminDTO findById(@PathVariable String id) {
        return service.findById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    AdminDTO update(@RequestBody @Valid AdminDTO adminEntry) {
        return service.update(adminEntry);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    AdminDTO login(@RequestBody @Valid AdminDTO adminEntry) {
        return service.login(adminEntry.getEmail(),adminEntry.getPassword());
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    AdminDTO logout(@RequestBody @Valid AdminDTO adminEntry) {
        return service.logout(adminEntry.getEmail(),adminEntry.getPassword());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(TodoNotFoundException ex) {
        ex.printStackTrace();
    }
}

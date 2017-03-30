package com.paperpigeon.controller;

import com.paperpigeon.dto.AdminDTO;
import com.paperpigeon.exception.ObjectAlreadyInDB;
import com.paperpigeon.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * This is the place where the whole magic happens. Here we create new REST calls
 * (GET, POST, etc), that can be than handled from outside (frontend, postman).
 */

@RestController
@RequestMapping("/api/admin")
public final class AdminController {

    private final AdminService service;

    @Autowired
    AdminController(AdminService service) {
        this.service = service;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    AdminDTO create(@RequestBody @Valid AdminDTO adminEntry) {
        try {
            return service.create(adminEntry);
        } catch (ObjectAlreadyInDB e) {
            System.out.println((e.getMessage()));
        }
        return null;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    AdminDTO delete(@RequestBody @Valid AdminDTO request) {
        return service.delete(request.getId());
    }

    /*@RequestMapping(value = "/findall", method = RequestMethod.GET)
    ModelAndView findAll() {
        ModelAndView result = new ModelAndView("admin/list");
        result.addObject("admins", service.findAll());
        return result;
    }*/

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    List<AdminDTO> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/findbyid/{id}", method = RequestMethod.GET)
    AdminDTO findById(@PathVariable String id) {
        return service.findById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    AdminDTO update(@RequestBody @Valid AdminDTO adminEntry) {
        return service.update(adminEntry);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    String login(@RequestBody @Valid AdminDTO adminEntry) {
        if(service.checkCredentials(adminEntry)){
            return "Admin " + adminEntry.getEmail() + " has been successfully logged in";
        } else return "Bad credentials";
    }
}
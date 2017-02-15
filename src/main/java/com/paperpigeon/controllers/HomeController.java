package com.paperpigeon.controllers;

import com.paperpigeon.dto.TodoDTO;
import com.paperpigeon.exceptions.TodoNotFoundException;
import com.paperpigeon.services.TodoService;
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
@RequestMapping("/")
public final class HomeController {

}
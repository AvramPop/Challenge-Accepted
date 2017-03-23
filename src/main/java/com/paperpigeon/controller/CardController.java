package com.paperpigeon.controller;

import com.paperpigeon.dto.CardDTO;
import com.paperpigeon.exception.CardNotFoundException;
import com.paperpigeon.service.CardService;
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
@RequestMapping("/api/card")
public final class CardController {

    private final CardService service;

    @Autowired
    CardController(CardService service) {
        this.service = service;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    CardDTO create(@RequestBody @Valid CardDTO cardEntry){
        return service.create(cardEntry);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    CardDTO delete(@RequestBody @Valid CardDTO request) {
        return service.delete(request.getId());
    }

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    ModelAndView findAll() {
        ModelAndView result = new ModelAndView("card/list");
        result.addObject("cards", service.findAll());
        return result;
    }

    @RequestMapping(value = "/findone/{id}", method = RequestMethod.GET)
    CardDTO findById(@PathVariable String id) {
        return service.findById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    CardDTO update(@RequestBody @Valid CardDTO cardEntry) {
        return service.update(cardEntry);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleCardNotFound(CardNotFoundException ex) {
        ex.printStackTrace();
    }
}

package com.paperpigeon.controller;

import com.paperpigeon.dto.OrderDTO;
import com.paperpigeon.exception.CardNotFoundException;
import com.paperpigeon.exception.UserNotFoundException;
import com.paperpigeon.service.OrderService;
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
@RequestMapping("/api/order")
public final class OrderController {

    private final OrderService service;

    @Autowired
    OrderController(OrderService service) {
        this.service = service;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    OrderDTO create(@RequestBody @Valid OrderDTO orderEntry) {
        try {
            return service.create(orderEntry);
        } catch (CardNotFoundException | UserNotFoundException e) {
            System.out.println((e.getMessage()));
        }
        return null;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    OrderDTO delete(@RequestBody @Valid OrderDTO request) {
        return service.delete(request.getId());
    }

    /*@RequestMapping(value = "/findall", method = RequestMethod.GET)
    ModelAndView findAll() {
        ModelAndView result = new ModelAndView("order/list");
        result.addObject("orders", service.findAll());
        return result;
    }*/

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    List<OrderDTO> findAll() {
          return service.findAll();
    }

    @RequestMapping(value = "/findbyid/{id}", method = RequestMethod.GET)
    OrderDTO findById(@PathVariable String id) {
        return service.findById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    OrderDTO update(@RequestBody @Valid OrderDTO orderEntry) {
        return service.update(orderEntry);
    }
}
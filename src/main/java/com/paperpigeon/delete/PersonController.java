package com.paperpigeon.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dani on 2/8/17.
 */
@RestController("/people")
@ExposesResourceFor(Person.class)
public class PersonController {
    private final PersonRepository repository;

    @Autowired
    public PersonController(PersonRepository repo) {
        repository = repo;
    }
    /*@RequestMapping(value = "/up")
    void updateFirstName(@Param("firstName") String firstName, @Param("id") String id);*/

    @RequestMapping(value = "/a", method = RequestMethod.GET)
    public void peopleWithFirstNameCool(/*@Param("id") String id*/){
        int i = 1;

        System.out.println("-----------------****************");
    }
}

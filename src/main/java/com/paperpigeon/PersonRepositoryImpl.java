package com.paperpigeon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by dani on 2/7/17.
 */
public class PersonRepositoryImpl implements CustomPersonRepository {
    private final MongoOperations operations;

    @Autowired
    public PersonRepositoryImpl(MongoOperations operations) {

        Assert.notNull(operations, "MongoOperations must not be null!");
        this.operations = operations;
    }

    public void updateFirstName(@Param("firstName") String firstName, @Param("id") String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));

        Person person = operations.findOne(query, Person.class);
        System.out.println(person);
        person.setFirstName(firstName);
        operations.save(person);
    }
}

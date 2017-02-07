package com.paperpigeon;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dani on 2/7/17.
 */
public interface CustomPersonRepository {

    @RequestMapping(value = "/updateFirstName", method = RequestMethod.PUT)
    void updateFirstName(@Param("firstName") String firstName, @Param("id") String id);
}

package com.paperpigeon.delete;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dani on 2/7/17.
 */
public interface CustomPersonRepository {
    @RequestMapping(value = "/up")
    void updateFirstName(@Param("firstName") String firstName, @Param("id") String id);

    @RequestMapping(value = "/magify")
    void magify(@Param("id") String id);
}

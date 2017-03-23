package com.paperpigeon.dto;


import com.paperpigeon.model.Admin;

import javax.validation.constraints.Size;

/**
 * This is the object we use as a information-holder for our REST calls. This means that we pass this object
 * as body in our controller, if we want a body(for the id, for example).
 *
 * A DTO (data transfer object) is meant to carry data between different processes,
 * in our case between the DB and the controller.
 * Every POJO should have this equivalent!
 */
public final class AdminDTO {

    private String id;

    @Size(max = Admin.MAX_LENGTH_EMAIL)
    private String email;

    //@NotEmpty
    @Size(max = Admin.MAX_LENGTH_PASSWORD)
    private String password;

    private String firstName;

    private String lastName;

    public AdminDTO findAdminById(String id){
        if(this.id.equals(id)){
            return this;
        } else {
            return null;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.paperpigeon.dto;


import com.paperpigeon.model.User;

import javax.validation.constraints.Size;

/**
 * This is the object we use as a information-holder for our REST calls. This means that we pass this object
 * as body in our controller, if we want a body(for the id, for example).
 *
 * A DTO (data transfer object) is meant to carry data between different processes,
 * in our case between the DB and the controller.
 * Every POJO should have this equivalent!
 */
public final class UserDTO {

    private String id;

    @Size(max = User.MAX_LENGTH_EMAIL)
    private String email;

    //@NotEmpty
    @Size(max = User.MAX_LENGTH_PASSWORD)
    private String password;

    public UserDTO findUserById(String id){
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

package com.paperpigeon.dto;

import com.paperpigeon.model.Admin;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Laura on 3/15/2017.
 */
public final class AdminDTO {

    private String id;
    @NotNull
    @NotEmpty
    @Size(max = Admin.MAX_NUMBER_OF_CHARACTERS)

    private String firstName;
    @NotNull
    @NotEmpty
    @Size(max = Admin.MAX_NUMBER_OF_CHARACTERS)
    private String lastName;

    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private String password;


    @NotNull
    @NotEmpty
    private boolean isLoggedIn;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public void setPassword(String password) {
        this.password = password;
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


}

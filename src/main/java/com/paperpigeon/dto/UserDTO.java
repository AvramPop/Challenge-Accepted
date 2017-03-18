package com.paperpigeon.dto;

import com.paperpigeon.model.User;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by Huzdu on 3/11/2017.
 *
 */
public final class UserDTO {
    private String id;

    @Size(max = User.MAX_LENGHT_USERNAME)
    private String userName = "";

    @NotEmpty
    @Size(max = User.MAX_LENGHT_PASSWORD)
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

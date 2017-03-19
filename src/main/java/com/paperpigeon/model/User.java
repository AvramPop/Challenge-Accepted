package com.paperpigeon.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by Huzdu on 3/11/2017.
 */
@Document(collection = "User")
public class User {
    public final static int MAX_LENGHT_USERNAME = 500;
    public final static int MAX_LENGHT_PASSWORD = 100;

    @Id
    private String id;

    @Field(value = "userName")
    private String userName;

    @Field(value = "password")
    private String password;

    public User() {
    }

    private User(Builder builder){
        this.userName = builder.userName;
        this.password = builder.password;
    }
    public static Builder getBuilder(){
        return new Builder();
    }

    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }
    public String getId(){
        return id;
    }
    public void update(String userName, String password){
        this.userName = userName;
        this.password = password;
    }


    public static class Builder {
        private String userName;
        private String password;

        public Builder(){}

        public Builder userName(String userName){
            this.userName = userName;
            return this;
        }
        public Builder password(String password){
            this.password = password;
            return this;
        }

        public User build(){
            User build = new User(this);
            if(build.checkUserNameAndPassword(build.getUserName(),build.getPassword())){
                return build;
            }
            throw new IllegalArgumentException();
        }

    }
    private boolean checkUserNameAndPassword(String userName, String password){
        if(userName == null){
            System.err.println("UserName cannot be null");
            return false;
        }
        if(userName.isEmpty()){
            System.err.println("UserName cannot be empty");
            return false;
        }
        if(userName.length() > MAX_LENGHT_USERNAME){
            System.err.println("UserName cannot be longer than " + MAX_LENGHT_USERNAME +" characters.");
            return false;
        }
        if(password != null){
            if(password.length() > MAX_LENGHT_PASSWORD){
                System.err.println("Password cannot be longer than " + MAX_LENGHT_PASSWORD + " characters.");
                return false;
        }
    }
 return true;
}
}
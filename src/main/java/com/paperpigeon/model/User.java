package com.paperpigeon.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * This is a POJO(Plain Old Java Object), so its purpose is to model a entity
 * that will be then handled by the DB, calls, and so on.
 */
@Document(collection = "User")
public final class User {

    public static final int MAX_LENGTH_EMAIL = 500;
    public static final int MAX_LENGTH_PASSWORD = 100;

    @Id
    private String id;

    @Field(value = "email")
    private String email;

    @Field(value = "password")
    private String password;

    public User() {}

    private User(Builder builder) {
        this.email = builder.email;
        this.password = builder.password;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public void magic() {
        this.password = this.password + "ish";
        System.out.println("magic happens");
    }

    public void update(String password, String email) {
        checkPasswordAndEmail(password, email);

        this.password = password;
        this.email = email;
    }

    /**
     * We don't have to use the builder pattern here because the constructed
     * class has only two String fields. However, I use the builder pattern
     * in this example because it makes the code a bit easier to read.
     */
    public static class Builder {

        private String email;

        private String password;

        private Builder() {}

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            User build = new User(this);
            if(build.checkPasswordAndEmail(build.getPassword(), build.getEmail())){
                return build;
            }
            throw new IllegalArgumentException();
        }
    }

    private boolean checkPasswordAndEmail(String password, String email) {
        if(password == null) {
            System.err.println("Password cannot be null");
            return false;
        }

        if(password.isEmpty()) {
            System.err.println("Password cannot be empty");
            return false;
        }

        if(password.length() > MAX_LENGTH_PASSWORD){
            System.err.println("Password cannot be longer than " + MAX_LENGTH_PASSWORD + " characters");
            return false;
        }

        if (email != null) {
            if(email.length() > MAX_LENGTH_EMAIL){
                System.err.println("Email cannot be longer than " + MAX_LENGTH_EMAIL + " characters");
                return false;
            }
        }

        return true;
    }
}

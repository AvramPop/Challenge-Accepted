package com.paperpigeon.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.security.auth.login.LoginException;

/**
 * Created by Laura on 3/15/2017.
 */
@Document(collection = "Admin")
public class Admin {
    @Id
    private String id;
    @Field(value = "firstName")
    private String firstName;
    @Field(value = "lastName")
    private String lastName;
    @Field(value = "email")
    private String email;
    @Field(value = "password")
    private String password;
    @Field(value = "isLoggedIn")
    private boolean isLoggedIn;

    public static final int MAX_NUMBER_OF_CHARACTERS = 50;
    public static final int MIN_NUMBER_OF_CHARACTERS = 2;


    private Admin(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
    }

    public static Builder getBuilder() {
        return new Builder();
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

    public boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }


    public void update(String firstName, String lastName, String email, String password) {
        checkFirstNameLastNameAndEmail(firstName, lastName, email, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public static class Builder {

        private String firstName;

        private String lastName;

        private String email;

        private String password;

        public Builder() {
        }

        public Admin.Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Admin.Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Admin.Builder email(String email) {
            this.email = email;
            return this;
        }

        public Admin.Builder password(String password) {
            this.password = password;
            return this;
        }

        public Admin build() {
            Admin build = new Admin(this);
            if (build.checkFirstNameLastNameAndEmail(build.getFirstName(), build.getLastName(), build.getEmail(), build.getPassword())) {
                return build;
            }
            throw new IllegalArgumentException();
        }
    }

    private boolean checkFirstNameLastNameAndEmail(String firstName, String lastName, String email, String password) {
        if (firstName == null) {
            System.err.println("First name cannot be null");
            return false;
        }

        if (lastName == null) {
            System.err.println("Last name cannot be null");
            return false;
        }

        if (email == null) {
            System.err.println("Email cannot be null");
            return false;
        }

        if (password == null) {
            System.err.println("Password cannot be null");
            return false;
        }

        if (firstName.length() > MAX_NUMBER_OF_CHARACTERS || firstName.length() < MIN_NUMBER_OF_CHARACTERS) {
            System.err.println("First name must have at least 2 characters and no more that 50");
            return false;
        }

        if (lastName.length() > MAX_NUMBER_OF_CHARACTERS || lastName.length() < MIN_NUMBER_OF_CHARACTERS) {
            System.err.println("Last name must have at least 2 characters and no more that 50");
            return false;
        }

        if (containsDigit(firstName)) {
            System.err.println("First name must not contain digits");
            return false;
        }

        if (containsDigit(lastName)) {
            System.err.println("Last name must not contain digits");
            return false;
        }


        return true;
    }

    private boolean containsDigit(String firstName) {
        boolean containsDigit = false;

        if (firstName != null && !firstName.isEmpty()) {
            for (char c : firstName.toCharArray()) {
                if (containsDigit = Character.isDigit(c)) {
                    break;
                }
            }
        }
        return containsDigit;
    }

    public void login(String email, String password) {
        if (getIsLoggedIn()) try {
            throw new LoginException("Already logged in");
        } catch (LoginException e) {
            e.printStackTrace();
        }
        if (this.getPassword().equals(password) && this.getEmail().equals(email)) {
            isLoggedIn = true;
            System.out.println("Logged in successfully");
        }
    }

    public void logout(String email, String password) {
        if (getIsLoggedIn()) {
            isLoggedIn = false;
            System.out.println("Logged out successfully");
        } else {
            try {
                throw new LoginException("Already logged out");
            } catch (LoginException e) {
                e.printStackTrace();
            }
        }
    }


}

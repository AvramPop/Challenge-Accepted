package com.paperpigeon;

import com.paperpigeon.model.Admin;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Laura on 3/18/2017.
 */
public class AdminTest {

    @Test
    public void checkIfFirstNameIsCreatedCorrect() {
        Admin admin = new Admin.Builder()
                .firstName("Turczi")
                .lastName("Laura")
                .email("laura_turczi89@yahoo.com")
                .password("paw").build();
        Assert.assertEquals(admin.getFirstName(),"Turczi");
    }

    @Test
    public void checkIfLastNameIsCreatedCorrect() {
        Admin admin = new Admin.Builder()
                .firstName("Turczi")
                .lastName("Laura")
                .email("laura_turczi89@yahoo.com")
                .password("paw").build();
        Assert.assertEquals(admin.getLastName(),"Laura");
    }

    @Test
    public void checkIfEmailIsCreatedCorrect() {
        Admin admin = new Admin.Builder()
                .firstName("Turczi")
                .lastName("Laura")
                .email("laura_turczi89@yahoo.com")
                .password("paw")
                .build();
        Assert.assertEquals(admin.getEmail(),"laura_turczi89@yahoo.com");
    }

    @Test
    public void checkIfPasswordIsCreatedCorrect() {
        Admin admin = new Admin.Builder()
                .firstName("Turczi")
                .lastName("Laura")
                .email("laura_turczi89@yahoo.com")
                .password("paw")
                .build();
        Assert.assertEquals(admin.getPassword(),"paw");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkIfFieldCantBeNull() {
        Admin admin = new Admin.Builder()
                .firstName("Turczi")
                .lastName("Laura")
                .email("laura_turczi89@yahoo.com")
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkIfFirstNameCantContainDigits() {
        Admin admin = new Admin.Builder()
                .firstName("Turc64zi")
                .lastName("Laura")
                .email("laura_turczi89@yahoo.com")
                .password("paw")
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkIfLastNameCantContainDigits() {
        Admin admin = new Admin.Builder()
                .firstName("Turczi")
                .lastName("La569ura")
                .email("laura_turczi89@yahoo.com")
                .password("paw")
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkIfLastNameCantBeLessThanTwoCharacters() {
        Admin admin = new Admin.Builder()
                .firstName("Turczi")
                .lastName("L")
                .email("laura_turczi89@yahoo.com")
                .password("paw")
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkIfFirstNameCantBeLessThanTwoCharacters() {
        Admin admin = new Admin.Builder()
                .firstName("T")
                .lastName("Laura")
                .email("laura_turczi89@yahoo.com")
                .password("paw")
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkIfFirstNameCantBeMoreThanFiftyCharacters() {
        Admin admin = new Admin.Builder()
                .firstName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
                .lastName("Laura")
                .email("laura_turczi89@yahoo.com")
                .password("paw")
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkIfLastNameCantBeMoreThanFiftyCharacters() {
        Admin admin = new Admin.Builder()
                .firstName("Turczi")
                .lastName("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
                .email("laura_turczi89@yahoo.com")
                .password("paw")
                .build();
    }
}

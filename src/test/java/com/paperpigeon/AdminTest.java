
package com.paperpigeon;
import com.paperpigeon.dto.AdminDTO;
import com.paperpigeon.model.Admin;
import com.paperpigeon.mongo_service.MongoAdminService;
import com.paperpigeon.repository.AdminRepository;
import org.junit.Assert;
import org.junit.Test;

import java.net.BindException;
import java.util.List;
import java.util.Optional;

/**
     * Created by Laura on 3/18/2017.
     */
    public class AdminTest {

        @Test
        public void checkIfFirstNameIsCreatedCorrect() {
            AdminDTO admin = new AdminDTO();
            admin.setFirstName("Laura");
            admin.setLastName("Turczi");
            admin.setEmail("laura_turczi89@yahoo.com");
            admin.setPassword("paw");
            Assert.assertEquals(admin.getFirstName(), "Laura");
        }

        @Test
        public void checkIfLastNameIsCreatedCorrect() {
            AdminDTO admin = new AdminDTO();
            admin.setFirstName("Laura");
            admin.setLastName("Turczi");
            admin.setEmail("laura_turczi89@yahoo.com");
            admin.setPassword("paw");
            Assert.assertEquals(admin.getLastName(), "Turczi");
        }

        @Test
        public void checkIfEmailIsCreatedCorrect() {
            AdminDTO admin = new AdminDTO();
            admin.setFirstName("Laura");
            admin.setLastName("Turczi");
            admin.setEmail("laura_turczi89@yahoo.com");
            admin.setPassword("paw");
            Assert.assertEquals(admin.getEmail(), "laura_turczi89@yahoo.com");
        }

        @Test
        public void checkIfPasswordIsCreatedCorrect() {
            AdminDTO admin = new AdminDTO();
            admin.setFirstName("Laura");
            admin.setLastName("Turczi");
            admin.setEmail("laura_turczi89@yahoo.com");
            admin.setPassword("paw");
            Assert.assertEquals(admin.getPassword(), "paw");
        }

    }
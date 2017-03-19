package com.paperpigeon.repository;

import com.paperpigeon.model.Admin;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;


/**
 * Created by Laura on 3/16/2017.
 */
public interface AdminRepository extends Repository<Admin, String> {

    void delete(Admin deleted);

    List<Admin> findAll();

    Optional<Admin> findOne(String id);

    Admin save(Admin saved);

    Admin findAdminById(String id);

    Admin login(String email, String password);

    Admin logut(String email, String password);
}

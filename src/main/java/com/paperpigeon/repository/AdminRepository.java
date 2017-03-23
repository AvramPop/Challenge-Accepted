package com.paperpigeon.repository;


import com.paperpigeon.model.Admin;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;
/**
 * Here are the operations linked to the repo,
 * they are probably the same for every object
 */

public interface AdminRepository extends Repository<Admin, String> {

    void delete(Admin deleted);

    List<Admin> findAll();

    Optional<Admin> findOne(String id);

    Admin save(Admin saved);
}
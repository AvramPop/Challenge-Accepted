package com.paperpigeon.service;


import com.paperpigeon.dto.AdminDTO;
import com.paperpigeon.exception.ObjectAlreadyInDB;

import java.util.List;

/**
 * Here are the methods of Admin that can be called via Rest.
 * If you want to add a new method, add it here, because the
 * DB service implements this interface.
 */

public interface AdminService {

    AdminDTO create(AdminDTO card) throws ObjectAlreadyInDB;

    AdminDTO delete(String id);

    List<AdminDTO> findAll();

    AdminDTO findById(String id);

    AdminDTO update(AdminDTO card);

    boolean checkCredentials(AdminDTO adminToLogin);
}
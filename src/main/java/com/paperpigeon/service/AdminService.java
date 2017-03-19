package com.paperpigeon.service;

import com.paperpigeon.dto.AdminDTO;
import com.paperpigeon.model.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Laura on 3/16/2017.
 */
@Service
public interface AdminService {

    AdminDTO create(AdminDTO adminDTO);

    AdminDTO delete(String id);

    AdminDTO update(AdminDTO adminDTO);

    List<AdminDTO> findAll();

    AdminDTO findById(String id);

    AdminDTO findByUserAndPassword(String password, String email);

    AdminDTO login(String email, String password);

    AdminDTO logout(String email, String password);


}

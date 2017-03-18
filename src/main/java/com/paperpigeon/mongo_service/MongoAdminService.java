package com.paperpigeon.mongo_service;

import com.paperpigeon.dto.AdminDTO;
import com.paperpigeon.model.Admin;
import com.paperpigeon.repository.AdminRepository;
import com.paperpigeon.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * Created by Laura on 3/18/2017.
 */
public class MongoAdminService implements AdminService {

    private final AdminRepository repository;

    @Autowired
    public MongoAdminService(AdminRepository repository) {
        this.repository = repository;
    }


    @Override
    public AdminDTO create(AdminDTO adminDTO) {
        Admin persisted = Admin.getBuilder()
                .firstName(adminDTO.getFirstName())
                .lastName(adminDTO.getLastName())
                .email(adminDTO.getEmail())
                .password(adminDTO.getPassword())
                .build();
        persisted = repository.save(persisted);
        return convertToDTO(persisted);
    }

    @Override
    public AdminDTO delete(String id) {
        Admin deleted = findAdminById(id);
        repository.delete(deleted);
        return convertToDTO(deleted);
    }


    @Override
    public AdminDTO update(AdminDTO adminDTO) {
        Admin updated = repository.findAdminById(adminDTO.getId());
        updated.update(adminDTO.getFirstName(), adminDTO.getLastName(), adminDTO.getEmail(), adminDTO.getPassword());
        updated = repository.save(updated);
        return convertToDTO(updated);
    }

    @Override
    public List<AdminDTO> findAll() {
        List<Admin> adminList = repository.findAll();
        return convertToDTOs(adminList);
    }

    @Override
    public AdminDTO findById(String id) {
        Admin found = findAdminById(id);
        return convertToDTO(found);
    }

    @Override
    public AdminDTO findByUserAndPassword(String password, String email) {
        List<Admin> adminList = repository.findAll();
        for (Admin admin : adminList) {
            if (admin.getPassword().equals(password) && admin.getEmail().equals(email))
                return convertToDTO(admin);
        }
        return null;
    }

    private Admin findAdminById(String id) {
        Optional<Admin> result = repository.findOne(id);
        return result.orElseThrow(() -> new NullPointerException(id));
    }


    private AdminDTO convertToDTO(Admin admin) {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setFirstName(admin.getFirstName());
        adminDTO.setLastName(admin.getLastName());
        adminDTO.setEmail(admin.getEmail());
        adminDTO.setPassword(admin.getPassword());
        return adminDTO;
    }

    private List<AdminDTO> convertToDTOs(List<Admin> adminEntries) {
        return adminEntries.stream().map(this::convertToDTO)
                .collect(toList());
    }

}

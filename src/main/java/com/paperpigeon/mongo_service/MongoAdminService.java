package com.paperpigeon.mongo_service;

import com.paperpigeon.dto.AdminDTO;
import com.paperpigeon.exception.ObjectAlreadyInDB;
import com.paperpigeon.repository.AdminRepository;
import com.paperpigeon.service.AdminService;
import com.paperpigeon.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * This is the place where we implement the methods from the controller(here, AdminController)
 * the way they behave and connect to the DB
 * <p>!NEVER forget to save your changes in the DB (obj = repository.save(obj))!!</p>
 */

@Service
public final class MongoAdminService implements AdminService {

    private final AdminRepository repository;

    @Autowired
    public MongoAdminService(AdminRepository repository) {
        this.repository = repository;
    }

    @Override
    public AdminDTO create(AdminDTO admin) throws ObjectAlreadyInDB {
        for(Admin adminEntry : repository.findAll()){
            if(adminEntry.getEmail().equals(admin.getEmail())) {
                throw new ObjectAlreadyInDB("Admin");
            }
        }
        Admin persisted = Admin.getBuilder()
                .email(admin.getEmail())
                .password(admin.getPassword())
                .firstName(admin.getFirstName())
                .lastName(admin.getLastName())
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
    public List<AdminDTO> findAll() {
        List<Admin> adminEntries = repository.findAll();
        return convertToDTOs(adminEntries);
    }

    private List<AdminDTO> convertToDTOs(List<Admin> models) {
        return models.stream()
                .map(this::convertToDTO)
                .collect(toList());
    }

    @Override
    public AdminDTO findById(String id) {
        Admin found = findAdminById(id);
        return convertToDTO(found);
    }

    @Override
    public AdminDTO update(AdminDTO admin) {
        Admin updated = findAdminById(admin.getId());
        String password = admin.getPassword() == null ? updated.getPassword() : admin.getPassword(),
                email = admin.getEmail() == null ? updated.getEmail() : admin.getEmail(),
                firstName = admin.getFirstName() == null ? updated.getFirstName() : admin.getFirstName(),
                lastName = admin.getLastName() == null ? updated.getLastName() : admin.getLastName();
        updated.update(password, email, firstName, lastName);
        updated = repository.save(updated);
        return convertToDTO(updated);
    }

    public boolean checkCredentials(AdminDTO adminToLogin) {
        List<Admin> adminEntries = repository.findAll();
        for(Admin admin : adminEntries){
            if(adminToLogin.getEmail().equals(admin.getEmail())
                    && adminToLogin.getPassword().equals(admin.getPassword())){
                return true;
            }
        }
        return false;
    }

    private Admin findAdminById(String id) {
        Optional<Admin> result = repository.findOne(id);
        return result.orElseThrow(() -> new NullPointerException(id));

    }

    private AdminDTO convertToDTO(Admin model) {
        AdminDTO dto = new AdminDTO();

        dto.setId(model.getId());
        dto.setEmail(model.getEmail());
        dto.setPassword(model.getPassword());
        dto.setLastName(model.getLastName());
        dto.setFirstName(model.getFirstName());

        return dto;
    }
}
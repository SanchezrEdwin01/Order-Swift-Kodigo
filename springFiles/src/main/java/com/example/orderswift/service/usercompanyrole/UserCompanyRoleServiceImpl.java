package com.example.orderswift.service.usercompanyrole;

import com.example.orderswift.exception.ResourceNotFoundException;
import com.example.orderswift.model.Company;
import com.example.orderswift.model.User;
import com.example.orderswift.model.UserCompanyRol;
import com.example.orderswift.repository.UserCompanyRoleRepository;
import com.example.orderswift.service.company.CompanyService;
import com.example.orderswift.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserCompanyRoleServiceImpl implements UserCompanyRoleService {
    private final UserCompanyRoleRepository roleRepository;
    private final UserService userService;
    private final CompanyService companyService;
    @Override
    public UserCompanyRol createRole(UserCompanyRol userCompanyRol) {
        User user = userService.getUser(userCompanyRol.getUser().getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Company company = companyService.getCompanyById(userCompanyRol.getCompany().getId());
        userCompanyRol.setUser(user);
        userCompanyRol.setCompany(company);
        return roleRepository.save(userCompanyRol);
    }

    @Override
    public List<UserCompanyRol> readRoles() {
        return roleRepository.findAll();
    }

    @Override
    public UserCompanyRol readRoleById(Integer id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found for the id " + id));
    }

    @Override
    public UserCompanyRol updateRole(Integer id, UserCompanyRol userCompanyRol) {
        UserCompanyRol existingRole = readRoleById(id);
        existingRole.setRole(userCompanyRol.getRole() != null ? userCompanyRol.getRole() : existingRole.getRole());
        existingRole.setCompany(userCompanyRol.getCompany() != null ?
                companyService.getCompanyById(userCompanyRol.getCompany().getId()) : existingRole.getCompany());
        existingRole.setUser(userCompanyRol.getUser() != null ?
                userService.getUser(userCompanyRol.getUser().getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found")) : existingRole.getUser());
        return roleRepository.save(existingRole);
    }

    @Override
    public String deleteRole(Integer id) {
        UserCompanyRol role = readRoleById(id);
        roleRepository.delete(role);
        return "Role with id " + id + " has been deleted";
    }
}

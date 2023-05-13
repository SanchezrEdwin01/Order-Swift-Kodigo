package com.example.orderswift.service.usercompanyrole;

import com.example.orderswift.model.UserCompanyRol;

import java.util.List;

public interface UserCompanyRoleService {
    UserCompanyRol createRole(UserCompanyRol userCompanyRol);
    List<UserCompanyRol> readRoles();
    UserCompanyRol readRoleById(Integer id);
    UserCompanyRol updateRole(Integer id, UserCompanyRol userCompanyRol);
    String deleteRole(Integer id);
}

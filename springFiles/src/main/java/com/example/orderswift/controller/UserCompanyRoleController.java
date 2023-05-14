package com.example.orderswift.controller;

import com.example.orderswift.model.UserCompanyRol;
import com.example.orderswift.service.usercompanyrole.UserCompanyRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
@RequiredArgsConstructor
public class UserCompanyRoleController {
    private final UserCompanyRoleService roleService;

    @GetMapping
    public List<UserCompanyRol> getRoles(){
        return roleService.readRoles();
    }

    @PostMapping("add")
    public ResponseEntity<UserCompanyRol> addRole(@RequestBody UserCompanyRol role){
        return new ResponseEntity<>(roleService.createRole(role), HttpStatus.CREATED);
    }

    @GetMapping("{roleId}")
    public UserCompanyRol getRoleById(@PathVariable Integer roleId){
        return roleService.readRoleById(roleId);
    }

    @PutMapping("{roleId}")
    public ResponseEntity<UserCompanyRol> editRole(@PathVariable Integer roleId,
                                                   @RequestBody UserCompanyRol role){
        return new ResponseEntity<>(roleService.updateRole(roleId, role), HttpStatus.OK);
    }

    @DeleteMapping("{roleId}")
    public String removeRole(@PathVariable Integer roleId) {
        return roleService.deleteRole(roleId);
    }
}

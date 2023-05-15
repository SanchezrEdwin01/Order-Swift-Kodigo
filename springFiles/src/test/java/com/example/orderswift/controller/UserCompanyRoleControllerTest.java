package com.example.orderswift.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.example.orderswift.model.UserCompanyRol;
import com.example.orderswift.service.usercompanyrole.UserCompanyRoleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserCompanyRoleControllerTest {

    @Mock
    private UserCompanyRoleService roleService;

    @InjectMocks
    private UserCompanyRoleController roleController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetRoles() {
        List<UserCompanyRol> roles = Arrays.asList(new UserCompanyRol(), new UserCompanyRol());
        when(roleService.readRoles()).thenReturn(roles);

        List<UserCompanyRol> result = roleController.getRoles();

        assertEquals(roles, result);
        verify(roleService, times(1)).readRoles();
    }

    @Test
    void testAddRole() {
        UserCompanyRol role = new UserCompanyRol();
        when(roleService.createRole(role)).thenReturn(role);

        ResponseEntity<UserCompanyRol> result = roleController.addRole(role);

        assertEquals(role, result.getBody());
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        verify(roleService, times(1)).createRole(role);
    }

    @Test
    void testGetRoleById() {
        Integer roleId = 1;
        UserCompanyRol role = new UserCompanyRol();
        when(roleService.readRoleById(roleId)).thenReturn(role);

        UserCompanyRol result = roleController.getRoleById(roleId);

        assertEquals(role, result);
        verify(roleService, times(1)).readRoleById(roleId);
    }

    @Test
    void testEditRole() {
        Integer roleId = 1;
        UserCompanyRol existingRole = new UserCompanyRol();
        UserCompanyRol newRole = new UserCompanyRol();
        when(roleService.updateRole(roleId, newRole)).thenReturn(existingRole);

        ResponseEntity<UserCompanyRol> result = roleController.editRole(roleId, newRole);

        assertEquals(existingRole, result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
        verify(roleService, times(1)).updateRole(roleId, newRole);
    }

    @Test
    void testRemoveRole() {
        Integer roleId = 1;
        String expectedResult = "Role deleted successfully";
        when(roleService.deleteRole(roleId)).thenReturn(expectedResult);

        String result = roleController.removeRole(roleId);

        assertEquals(expectedResult, result);
        verify(roleService, times(1)).deleteRole(roleId);
    }
}

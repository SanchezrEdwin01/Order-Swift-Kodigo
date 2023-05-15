package com.example.orderswift.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.example.orderswift.model.User;
import com.example.orderswift.service.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void testGetAll() throws Exception {
        List<User> users = Arrays.asList(new User(), new User());
        when(userService.getUsers()).thenReturn(users);

        mockMvc.perform(get("/api/v1/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0]").exists())
                .andExpect(jsonPath("$[1]").exists())
                .andExpect(jsonPath("$.length()").value(2));

        verify(userService, times(1)).getUsers();
    }

    @Test
    void testSaveUpdate() throws Exception {
        User user = new User();
        String requestBody = "{\"username\":\"testUser\", \"password\":\"testPass\"}";

        mockMvc.perform(post("/api/v1/users/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk());

        verify(userService, times(1)).saveOrUpdate(user);
    }

    @Test
    void testDelete() throws Exception {
        int userId = 1;

        mockMvc.perform(delete("/api/v1/users/{userId}", userId))
                .andExpect(status().isOk());

        verify(userService, times(1)).delete(userId);
    }

    @Test
    void testGetById() throws Exception {
        int userId = 1;
        User user = new User();
        Optional<User> optionalUser = Optional.of(user);
        when(userService.getUser(userId)).thenReturn(optionalUser);

        mockMvc.perform(get("/api/v1/users/{userId}", userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());

        verify(userService, times(1)).getUser(userId);
    }
}

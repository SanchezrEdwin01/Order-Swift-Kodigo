package com.example.orderswift;


import com.example.orderswift.controller.UserController;
import com.example.orderswift.model.User;
import com.example.orderswift.service.user.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userServic;

    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userController = new UserController(userServic);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void testGetAll() throws Exception {
        User user1 = new User(1, "John");
        User user2 = new User(2, "Jane");
        List<User> users = Arrays.asList(user1, user2);

        when(userServic.getUsers()).thenReturn(users);

        MvcResult result = mockMvc.perform(get("/api/v1/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();
        List<User> responseUsers = new ObjectMapper().readValue(responseBody, new TypeReference<List<User>>() {});

        assertEquals(users.size(), responseUsers.size());
        assertEquals(users.get(0).getUserId(), responseUsers.get(0).getUserId());
        assertEquals(users.get(0).getFirstName(), responseUsers.get(0).getUserName());
        assertEquals(users.get(1).getUserId(), responseUsers.get(1).getUserId());
        assertEquals(users.get(1).getUserName(), responseUsers.get(1).getUserName());

        verify(userServic, times(1)).getUsers();
        verifyNoMoreInteractions(userServic);
    }



    @Test
    void testSaveUpdate() throws Exception {
        User user = new User(1, "John");

        mockMvc.perform(post("/api/v1/users/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 1, \"name\": \"John\"}"))
                .andExpect(status().isOk());

        verify(userServic, times(1)).saveOrUpdate(user);
        verifyNoMoreInteractions(userServic);
    }

    @Test
    void testDelete() throws Exception {
        int userId = 1;

        mockMvc.perform(delete("/api/v1/users/{userId}", userId))
                .andExpect(status().isOk());

        verify(userServic, times(1)).delete(userId);
        verifyNoMoreInteractions(userServic);
    }

    @Test
    void testGetById() throws Exception {
        int userId = 1;
        User user = new User(1, "John");

        when(userServic.getUser(userId)).thenReturn(Optional.of(user));

        mockMvc.perform(get("/api/v1/users/{userId}", userId))
                .andExpect(status().isOk());

        verify(userServic, times(1)).getUser(userId);
        verifyNoMoreInteractions(userServic);
    }
}

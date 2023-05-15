package com.example.orderswift.controller;

import com.example.orderswift.controller.AdminController;
import com.example.orderswift.service.product.ProductServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AdminControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProductServiceImp productService;

    @InjectMocks
    private AdminController adminController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
    }


    @Test
    public void testDeleteProduct() throws Exception {
        int productId = 1;

        mockMvc.perform(MockMvcRequestBuilders.delete("/admin/delete/{productId}", productId))
                .andExpect(status().isOk());

        verify(productService, times(1)).deleteProduct(productId);
        verifyNoMoreInteractions(productService);
    }
}


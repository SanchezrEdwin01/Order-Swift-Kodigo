package com.example.orderswift.service.product;

import static org.junit.jupiter.api.Assertions.*;

import com.example.orderswift.model.Product;
import com.example.orderswift.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceImpTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImp productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


}

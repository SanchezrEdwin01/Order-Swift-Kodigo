package com.example.orderswift;

import com.example.orderswift.controller.CompanyController;
import com.example.orderswift.model.Company;
import com.example.orderswift.service.company.CompanyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class CompanyControllerTest {
    private MockMvc mockMvc;

    @InjectMocks
    private CompanyController companyController;

    @Mock
    private CompanyService companyService;

    private ObjectMapper objectMapper;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(companyController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testGetCompanies() throws Exception {
        List<Company> companies = Arrays.asList(
                new Company(1, "Empresa 1", "contacto1@empresa.com", "Tech", "Empresa tech", LocalDate.now()),
                new Company(2, "Empresa 2", "contacto2@empresa.com", "Tech ", "Empresa tech 2", LocalDate.now())
        );

        when(companyService.getAllCompanies()).thenReturn(companies);

        String expectedResponse = objectMapper.writeValueAsString(companies);

        mockMvc.perform(get("/company"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponse));

        verify(companyService, times(1)).getAllCompanies();
        verifyNoMoreInteractions(companyService);
    }

    @Test
    public void testGetCompanyById() throws Exception {
        Company company = new Company(1, "Company 1", "contact@company1.com", "Industry 1", "Description 1", LocalDate.now());

        when(companyService.getCompanyById(1)).thenReturn(company);

        String expectedResponse = objectMapper.writeValueAsString(company);

        mockMvc.perform(get("/company/{companyId}", 1))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponse));

        verify(companyService, times(1)).getCompanyById(1);
        verifyNoMoreInteractions(companyService);
    }
}

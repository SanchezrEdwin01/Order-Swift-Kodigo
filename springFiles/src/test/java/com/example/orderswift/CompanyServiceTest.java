package com.example.orderswift;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.orderswift.exception.ResourceNotFoundException;
import com.example.orderswift.model.Company;
import com.example.orderswift.repository.CompanyRepository;

import com.example.orderswift.service.Company.CompanyServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CompanyServiceTest {
    @Mock
    private CompanyRepository companyRepository;

    @InjectMocks
    private CompanyServiceImpl companyService;

    @Test
    public void testCreateCompany() {
        Company company = new Company();
        company.setName("Empresa");
        company.setContact("empresa@gmail.com");
        company.setIndustry("Tech");
        company.setDescription("Descripción");
        company.setSubscriptionDate(LocalDate.of(2023, 5, 11).atStartOfDay());

        when(companyRepository.save(any(Company.class))).thenReturn(company);

        Company result = companyService.createCompany(company);

        assertNotNull(result);
        assertEquals(company.getName(), result.getName());
        assertEquals(company.getContact(), result.getContact());
        assertEquals(company.getIndustry(), result.getIndustry());
        assertEquals(company.getDescription(), result.getDescription());
        assertEquals(company.getSubscriptionDate(), result.getSubscriptionDate());
    }

    @Test
    public void testGetAllCompanies() {
        List<Company> companies = new ArrayList<>();
        companies.add(new Company(1, "Compañía 1", "contacto1@gmail.com", "Industria 1", "Descripción 1", LocalDate.now()));
        companies.add(new Company(2, "Compañía 2", "contacto2@gmail.com", "Industria 2", "Descripción 2", LocalDate.now()));
        companies.add(new Company(3, "Compañía 3", "contacto3@gmail.com", "Industria 3", "Descripción 3", LocalDate.now()));


        when(companyRepository.findAll()).thenReturn(companies);


        List<Company> result = companyService.getAllCompanies();

        assertNotNull(result);
        assertEquals(companies.size(), result.size());
        for (int i = 0; i < companies.size(); i++) {
            assertEquals(companies.get(i).getId(), result.get(i).getId());
            assertEquals(companies.get(i).getName(), result.get(i).getName());
            assertEquals(companies.get(i).getContact(), result.get(i).getContact());
            assertEquals(companies.get(i).getIndustry(), result.get(i).getIndustry());
            assertEquals(companies.get(i).getDescription(), result.get(i).getDescription());
            assertEquals(companies.get(i).getSubscriptionDate(), result.get(i).getSubscriptionDate());
        }
    }
}
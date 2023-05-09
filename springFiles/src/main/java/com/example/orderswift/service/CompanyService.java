package com.example.orderswift.service;

import com.example.orderswift.model.Company;

import java.util.List;

public interface CompanyService {
    Company createCompany(Company company);
    List<Company> getAllCompanies();
    Company getCompanyById(Integer id);
}

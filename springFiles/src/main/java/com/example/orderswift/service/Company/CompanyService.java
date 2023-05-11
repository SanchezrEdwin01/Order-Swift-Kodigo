package com.example.orderswift.service.Company;

import com.example.orderswift.model.Company;

import java.util.List;

public interface CompanyService {
    Company createCompany(Company company);
    List<Company> getAllCompanies();
    Company getCompanyById(Integer id);
    Company updateCompany(Integer id, Company company);
    String deleteCompany(Integer id);
}

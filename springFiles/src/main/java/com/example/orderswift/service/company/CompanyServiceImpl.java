package com.example.orderswift.service.company;

import com.example.orderswift.model.Company;
import com.example.orderswift.exception.ResourceNotFoundException;
import com.example.orderswift.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Integer id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found for the id " + id));
    }

    @Override
    public Company updateCompany(Integer id, Company company) {
        Company existingCompany = this.getCompanyById(id);
        existingCompany.setName(company.getName() != null ? company.getName() : existingCompany.getName());
        existingCompany.setContact(company.getContact() != null ? company.getContact() : existingCompany.getContact());
        existingCompany.setIndustry(company.getIndustry() != null ? company.getIndustry() : existingCompany.getIndustry());
        existingCompany.setDescription(company.getDescription() != null ? company.getDescription() : existingCompany.getDescription());
        return companyRepository.save(existingCompany);
    }

    @Override
    public String deleteCompany(Integer id) {
        Company company = this.getCompanyById(id);
        companyRepository.delete(company);
        return "Company with id " + id + " has been deleted";
    }
}

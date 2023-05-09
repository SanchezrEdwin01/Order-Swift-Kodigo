package com.example.orderswift.controller;

import com.example.orderswift.model.Company;
import com.example.orderswift.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("company")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getCompanies(){
        return companyService.getAllCompanies();
    }

    @GetMapping("{companyId}")
    public Company getCompanyById(@PathVariable() Integer companyId){
        return companyService.getCompanyById(companyId);
    }

    @PostMapping("add")
    public ResponseEntity<Company> addCompany(@RequestBody Company company){
        return new ResponseEntity<>(companyService.createCompany(company), HttpStatus.CREATED);
    }
}

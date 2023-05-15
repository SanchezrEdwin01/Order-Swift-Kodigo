package com.example.orderswift.controller;

import com.example.orderswift.model.Company;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.example.orderswift.service.company.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Company", description = "This controller makes a CRUD of all the companies register into Order Swift")
@RestController
@RequestMapping("company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

    @Operation(summary = "This operator get all the companies exist in the system")
    @GetMapping
    public List<Company> getCompanies(){
        return companyService.getAllCompanies();
    }

    @Operation(summary = "It gets a company by its id")
    @GetMapping("{companyId}")
    public Company getCompanyById(@PathVariable() Integer companyId){
        return companyService.getCompanyById(companyId);
    }

    @Operation(summary = "It adds a new company")
    @PostMapping("add")
    public ResponseEntity<Company> addCompany(@Valid @RequestBody Company company){
        return new ResponseEntity<>(companyService.createCompany(company), HttpStatus.CREATED);
    }

    @Operation(summary = "It updates a company")
    @PutMapping("{companyId}")
    public ResponseEntity<Company> editCompany(@Valid @PathVariable Integer companyId,@RequestBody Company company){
        return new ResponseEntity<>(companyService.updateCompany(companyId, company), HttpStatus.OK);
    }

    @Operation(summary = "It deletes a company")
    @DeleteMapping("{companyId}")
    public ResponseEntity<String> removeCompany(@PathVariable Integer companyId){
        return new ResponseEntity<>(companyService.deleteCompany(companyId), HttpStatus.NO_CONTENT);
    }
}

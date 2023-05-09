package com.example.orderswift.controller;

import com.example.orderswift.model.Company;
import lombok.RequiredArgsConstructor;
import com.example.orderswift.service.Company.CompanyService;
>>>>>>> 38a1a0a (Changes in the structure and adding the orderDetail CRUD)
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;

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

    @PutMapping("{companyId}")
    public ResponseEntity<Company> editCompany(@PathVariable Integer companyId,
                                               @RequestBody Company company){
        return new ResponseEntity<>(companyService.updateCompany(companyId, company), HttpStatus.OK);
    }

    @DeleteMapping("{companyId}")
    public ResponseEntity<String> removeCompany(@PathVariable Integer companyId){
        return new ResponseEntity<>(companyService.deleteCompany(companyId), HttpStatus.NO_CONTENT);
    }
}

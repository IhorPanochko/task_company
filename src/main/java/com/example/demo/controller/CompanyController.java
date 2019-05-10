package com.example.demo.controller;

import com.example.demo.dto.CompanyDto;
import com.example.demo.entity.Company;
import com.example.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping()
    public ResponseEntity createCompany(@RequestBody CompanyDto companyCreateDto){
        companyService.create(companyCreateDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id){
        return new ResponseEntity<>(companyService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCompany(@PathVariable Long id){
         companyService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity editCompany(@RequestBody CompanyDto companyDto){
         companyService.editCompany(companyDto);
         return new ResponseEntity<>(HttpStatus.OK);

    }

}

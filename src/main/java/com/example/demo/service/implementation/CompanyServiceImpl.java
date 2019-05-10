package com.example.demo.service.implementation;

import com.example.demo.dto.CompanyDto;
import com.example.demo.entity.Company;
import com.example.demo.entity.Department;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {


    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public void create(CompanyDto companyDto) {
     companyRepository.save(new Company(companyDto.getName(),companyDto.getAddress(),companyDto.getEmail(),companyDto.getPostCode()));
    }

    @Override
    public void delete(Long id) {
     companyRepository.deleteById(id);
    }

    @Override
    public Company findById(Long id) {
        return companyRepository.findById(id).get();
    }

    @Override
    public Company findByDepartmaent(Department department) {
        return companyRepository.findByDepartments(department);
    }

    @Override
    public void editCompany(CompanyDto company) {
        Company company1=companyRepository.findByEmail(company.getEmail());
        company1.setAddress(company.getAddress());
        company1.setName(company.getName());
        company1.setPostCode(company.getPostCode());
        companyRepository.save(company1);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }


}

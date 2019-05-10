package com.example.demo.service;


import com.example.demo.dto.CompanyDto;
import com.example.demo.entity.Company;
import com.example.demo.entity.Department;

import java.util.List;

public interface CompanyService {

    void create(CompanyDto company);

    void delete(Long id);

    Company findById(Long id);

    Company findByDepartmaent(Department department);

    void editCompany(CompanyDto company);

    List<Company> getAllCompanies();


}

package com.example.demo.service.implementation;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.entity.Company;
import com.example.demo.entity.Department;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceimpl implements DepartmentService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public void creat(DepartmentDto department) {

        departmentRepository.save(new Department(department.getName(),companyRepository.getOne(department.getCompanyId())));
    }

    @Override
    public void create(DepartmentDto department, Long companyId) {
       departmentRepository.save(new Department(department.getName(),companyRepository.getOne(companyId)));
    }

    @Override
    public void delete(Department department) {
       departmentRepository.delete(department);
    }

    @Override
    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }


    @Override
    public Department getById(Long id) {
        return departmentRepository.getOne(id);
    }

    @Override
    public void update(DepartmentDto department) {
        Department department1=departmentRepository.getOne(department.getId());
        department1.setName(department.getName());
        department1.setCompany(companyRepository.getOne(department.getCompanyId()));
        departmentRepository.save(department1);
    }
}

package com.example.demo.service;


import com.example.demo.dto.DepartmentDto;
import com.example.demo.entity.Company;
import com.example.demo.entity.Department;

import java.util.List;

public interface DepartmentService {

    void creat(DepartmentDto department);

    void create(DepartmentDto department, Long companyId);

    void delete(Department department);

    void delete(Long id);




    Department getById(Long id);

    void update(DepartmentDto department);
}

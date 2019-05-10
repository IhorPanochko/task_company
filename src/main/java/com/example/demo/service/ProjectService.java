package com.example.demo.service;


import com.example.demo.dto.ProjectDto;
import com.example.demo.entity.Company;
import com.example.demo.entity.Person;
import com.example.demo.entity.Project;

import java.util.List;

public interface ProjectService {

    void create(ProjectDto project);

    void create(Project project, Company company);

    void delete(Long id );

    void delete(Project project);


    Project findById(Long id);

    void update(ProjectDto project);
}

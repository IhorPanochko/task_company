package com.example.demo.service.implementation;

import com.example.demo.dto.ProjectDto;
import com.example.demo.entity.Company;
import com.example.demo.entity.Person;
import com.example.demo.entity.Project;
import com.example.demo.repository.*;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{


    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ProjectRepository projectRepository;


    @Override
    public void create(ProjectDto project) {
      projectRepository.save(new Project(project.getName(),companyRepository.getOne(project.getCompanyId())));
    }

    @Override
    public void create(Project project, Company company) {

        project.setCompany(company);
       projectRepository.save(project);

    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public void delete(Project project) {
         projectRepository.delete(project);
    }

    @Override
    public Project findById(Long id) {
        return projectRepository.getOne(id);
    }

    @Override
    public void update(ProjectDto project) {
        Project project1=projectRepository.getOne(project.getId());
        project1.setName(project.getName());
        project1.setCompany(companyRepository.getOne(project.getCompanyId()));
        projectRepository.save(project1);
    }
}

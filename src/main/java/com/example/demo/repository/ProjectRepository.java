package com.example.demo.repository;

import com.example.demo.entity.Company;
import com.example.demo.entity.Person;
import com.example.demo.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
    List<Project>findAllByPersons(Person person);

    List<Project>findAllByCompany(Company company);

    Project findByName(String name);
}

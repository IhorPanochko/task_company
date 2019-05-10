package com.example.demo.repository;

import com.example.demo.entity.Person;
import com.example.demo.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

    List<Person>findAllByProject(Project project);

    Person findByEmail(String email);

}

package com.example.demo.service;

import com.example.demo.dto.PersonDto;
import com.example.demo.entity.Person;
import com.example.demo.entity.Position;
import com.example.demo.entity.Project;

import java.util.List;

public interface PersonService {

    void create(PersonDto person);

    void create(Person person, Position position);

    void delete(Person person);

    void delete(Long id);

    List<Person> findAll();

    List<Person> findByProject(Project project);

    Person findById(Long id);

    Person findByEmail(String email);

    void update(PersonDto person);

}

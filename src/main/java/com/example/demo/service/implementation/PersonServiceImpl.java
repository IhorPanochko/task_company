package com.example.demo.service.implementation;

import com.example.demo.dto.PersonDto;
import com.example.demo.entity.Person;
import com.example.demo.entity.Position;
import com.example.demo.entity.Project;
import com.example.demo.repository.*;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void create(PersonDto person)
    {
       personRepository.save(new Person(person.getName(),
                                        person.getSecondName(),
                                        person.getEmail(),
                                        person.getPhone(),
                                        projectRepository.getOne(person.getProjectId()),
                                        departmentRepository.getOne(person.getDepartmentId()),
                                        positionRepository.getOne(person.getPositionId()) ));
    }

    @Override
    public void create(Person person, Position position) {
       person.setPosition(position);
       personRepository.save(person);
    }

    @Override
    public void delete(Person person) {
       personRepository.delete(person);
    }

    @Override
    public void delete(Long id) {
     personRepository.deleteById(id);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public List<Person> findByProject(Project project) {
        return personRepository.findAllByProject(project);
    }

    @Override
    public Person findById(Long id) {
        return personRepository.getOne(id);
    }

    @Override
    public Person findByEmail(String email) {
        return personRepository.findByEmail(email);
    }

    @Override
    public void update(PersonDto person) {
        Person person1=personRepository.getOne(person.getId());
        person1.setName(person.getName());
        person1.setSecondName(person.getSecondName());
        person1.setPhone(person.getPhone());
        person1.setPosition(positionRepository.getOne(person.getPositionId()));
        person1.setDepartment(departmentRepository.getOne(person.getDepartmentId()));
        person1.setProject(projectRepository.getOne(person.getProjectId()));
        personRepository.save(person1);
    }
}

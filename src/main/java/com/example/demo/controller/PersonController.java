package com.example.demo.controller;

import com.example.demo.dto.PersonDto;
import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity createPerson(@RequestBody PersonDto personDto){
        personService.create(personDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePerson(@PathVariable Long id){
        personService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id){
        return new ResponseEntity<>(personService.findById(id), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity editPerson(@RequestBody PersonDto personDto){
        personService.update(personDto);
        return new ResponseEntity(HttpStatus.OK);
    }

}

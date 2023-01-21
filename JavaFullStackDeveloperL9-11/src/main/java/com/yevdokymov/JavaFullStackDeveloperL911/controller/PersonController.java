package com.yevdokymov.JavaFullStackDeveloperL911.controller;

import com.yevdokymov.JavaFullStackDeveloperL911.model.PersonThatSheltered;
import com.yevdokymov.JavaFullStackDeveloperL911.service.PersonService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public ResponseEntity<PersonThatSheltered> createPerson(@RequestBody PersonThatSheltered person){
        return new ResponseEntity<PersonThatSheltered>(personService.createPerson(person), HttpStatus.CREATED);
    }
    @GetMapping
    public List<PersonThatSheltered> getAllPersons(){
        return personService.getAllPersons();
    }
   }

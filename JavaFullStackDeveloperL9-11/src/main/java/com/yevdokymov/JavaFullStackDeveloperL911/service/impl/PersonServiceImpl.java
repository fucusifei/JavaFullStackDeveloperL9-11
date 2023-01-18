package com.yevdokymov.JavaFullStackDeveloperL911.service.impl;

import com.yevdokymov.JavaFullStackDeveloperL911.repository.PersonRepository;
import com.yevdokymov.JavaFullStackDeveloperL911.model.PersonThatSheltered;
import com.yevdokymov.JavaFullStackDeveloperL911.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;
    public PersonServiceImpl(PersonRepository personDao) {
        this.personRepository = personDao;
    }

    @Override
    public PersonThatSheltered createPerson(PersonThatSheltered person) {
        return personRepository.save(person);
    }

    @Override
    public List<PersonThatSheltered> getAllPersons() {
        return personRepository.findAll();
    }

}

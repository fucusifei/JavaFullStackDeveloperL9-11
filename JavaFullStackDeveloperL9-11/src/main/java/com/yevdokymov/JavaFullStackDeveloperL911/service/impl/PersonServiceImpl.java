package com.yevdokymov.JavaFullStackDeveloperL911.service.impl;

import com.yevdokymov.JavaFullStackDeveloperL911.dao.PersonDao;
import com.yevdokymov.JavaFullStackDeveloperL911.model.PersonThatSheltered;
import com.yevdokymov.JavaFullStackDeveloperL911.service.PersonService;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonDao personDao;
    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public PersonThatSheltered createPerson(PersonThatSheltered person) {
        return personDao.save(person);
    }
}

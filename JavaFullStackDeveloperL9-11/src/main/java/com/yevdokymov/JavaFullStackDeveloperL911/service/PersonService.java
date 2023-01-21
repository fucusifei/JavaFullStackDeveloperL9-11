package com.yevdokymov.JavaFullStackDeveloperL911.service;

import com.yevdokymov.JavaFullStackDeveloperL911.model.PersonThatSheltered;

import java.util.List;

public interface PersonService {
    PersonThatSheltered createPerson(PersonThatSheltered person);
    List<PersonThatSheltered> getAllPersons();
}

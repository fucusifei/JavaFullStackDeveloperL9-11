package com.yevdokymov.JavaFullStackDeveloperL911.repository;

import com.yevdokymov.JavaFullStackDeveloperL911.model.PersonThatSheltered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonThatSheltered,Long> {
}

package com.yevdokymov.JavaFullStackDeveloperL911.dao;

import com.yevdokymov.JavaFullStackDeveloperL911.model.PersonThatSheltered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDao extends JpaRepository<PersonThatSheltered,Long> {
}

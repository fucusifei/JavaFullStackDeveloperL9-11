package com.yevdokymov.JavaFullStackDeveloperL911.dao;

import com.yevdokymov.JavaFullStackDeveloperL911.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalDao extends JpaRepository<Animal,Long> {

}

package com.yevdokymov.JavaFullStackDeveloperL911.repository;

import com.yevdokymov.JavaFullStackDeveloperL911.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal,Long> {

}

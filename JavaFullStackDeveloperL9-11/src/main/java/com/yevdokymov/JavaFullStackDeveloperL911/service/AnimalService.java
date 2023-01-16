package com.yevdokymov.JavaFullStackDeveloperL911.service;

import com.yevdokymov.JavaFullStackDeveloperL911.model.Animal;

import java.util.List;

public interface AnimalService {
    Animal createAnimal(Animal animal);
    List<Animal> getAllAnimals();
    Animal updateAnimal(Animal animal, long id);
    void deleteAnimal(long id);
}

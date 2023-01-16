package com.yevdokymov.JavaFullStackDeveloperL911.service.impl;

import com.yevdokymov.JavaFullStackDeveloperL911.exception.ResourceNotFoundException;
import com.yevdokymov.JavaFullStackDeveloperL911.model.Animal;
import com.yevdokymov.JavaFullStackDeveloperL911.dao.AnimalDao;
import com.yevdokymov.JavaFullStackDeveloperL911.service.AnimalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {
    private AnimalDao animalDao;
    public AnimalServiceImpl(AnimalDao animalDao) {
        this.animalDao = animalDao;
    }

    @Override
    public Animal createAnimal(Animal animal){
        return animalDao.save(animal);
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animalDao.findAll();
    }

    @Override
    public Animal updateAnimal(Animal animal, long id) {
        Animal animalIsExist = animalDao.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Animal","id",id));

        animalIsExist.setKindOfAnimal(animal.getKindOfAnimal());
        animalIsExist.setAge(animal.getAge());
        animalIsExist.setGender(animal.getGender());
        animalIsExist.setHeight(animal.getHeight());
        animalIsExist.setName(animal.getName());
        animalIsExist.setIssueDate(animal.getIssueDate());
        animalIsExist.setWeight(animal.getWeight());
        animalIsExist.setLength(animal.getLength());

        animalDao.save(animalIsExist);
        return animalIsExist;
    }

    @Override
    public void deleteAnimal(long id) {
        animalDao.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Animal","id",id));
        animalDao.deleteById(id);
    }

}

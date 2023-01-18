package com.yevdokymov.JavaFullStackDeveloperL911.service.impl;

import com.yevdokymov.JavaFullStackDeveloperL911.exception.ResourceNotFoundException;
import com.yevdokymov.JavaFullStackDeveloperL911.model.Animal;
import com.yevdokymov.JavaFullStackDeveloperL911.repository.AnimalRepository;
import com.yevdokymov.JavaFullStackDeveloperL911.service.AnimalService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {
    private AnimalRepository animalRepository;
    public AnimalServiceImpl(AnimalRepository animalDao) {
        this.animalRepository = animalDao;
    }

    @Override
    public Animal createAnimal(Animal animal){
        return animalRepository.save(animal);
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @Override
    public Animal updateAnimal(Animal animal, long id) {
        Animal animalIsExist = animalRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Animal","id",id));

        animalIsExist.setKindOfAnimal(animal.getKindOfAnimal());
        animalIsExist.setAge(animal.getAge());
        animalIsExist.setGender(animal.getGender());
        animalIsExist.setHeight(animal.getHeight());
        animalIsExist.setName(animal.getName());
        animalIsExist.setIssueDate(animal.getIssueDate());
        animalIsExist.setWeight(animal.getWeight());
        animalIsExist.setLength(animal.getLength());

        animalRepository.save(animalIsExist);
        return animalIsExist;
    }

    @Override
    public void deleteAnimal(long id) {
        animalRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Animal","id",id));
        animalRepository.deleteById(id);
    }

    @Override
    public List<Animal> findAnimals(HttpServletRequest request) {
        List<String> parameterNames = new ArrayList<String>(request.getParameterMap().keySet());
        List<Animal> animals = animalRepository.findAll();
        for (String parameterName: parameterNames) {
            switch (parameterName) {
                case "id" : animals = animals.stream().filter(x->String.valueOf(x.getId()).equals(request.getParameter(parameterName))).toList();
                    break;
                case "name" : animals = animals.stream().filter(x->x.getName().equals(request.getParameter(parameterName))).toList();
                    break;
                case "kind_of_animal" : animals = animals.stream().filter(x->x.getKindOfAnimal().equals(request.getParameter(parameterName))).toList();
                    break;
                case "gender" : animals = animals.stream().filter(x->x.getGender().equals(request.getParameter(parameterName))).toList();
                    break;
                case "age" : animals = animals.stream().filter(x->String.valueOf(x.getAge()).equals(request.getParameter(parameterName))).toList();
                    break;
                case "height" : animals = animals.stream().filter(x->String.valueOf(x.getHeight()).equals(request.getParameter(parameterName))).toList();
                    break;
                case "length" : animals = animals.stream().filter(x->String.valueOf(x.getLength()).equals(request.getParameter(parameterName))).toList();
                    break;
                case "weight" : animals = animals.stream().filter(x->String.valueOf(x.getWeight()).equals(request.getParameter(parameterName))).toList();
                    break;
                case "issue_date" : animals = animals.stream().filter(x->String.valueOf(x.getIssueDate()).equals(request.getParameter(parameterName))).toList();
                    break;
                case "receiving_date" : animals = animals.stream().filter(x->String.valueOf(x.getReceivingDate()).equals(request.getParameter(parameterName))).toList();
                    break;
                case "id_person" : animals = animals.stream().filter(x->String.valueOf(x.getPersonThatSheltered().getId()).equals(request.getParameter(parameterName))).toList();
                    break;
            }
        }
        return animals;
    }

}

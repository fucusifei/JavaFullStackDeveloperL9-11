package com.yevdokymov.JavaFullStackDeveloperL911.controller;

import com.yevdokymov.JavaFullStackDeveloperL911.model.Animal;
import com.yevdokymov.JavaFullStackDeveloperL911.service.AnimalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {
    private AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping
    public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal){
        return new ResponseEntity<Animal>(animalService.createAnimal(animal),HttpStatus.CREATED);
    }
    @GetMapping
    public List<Animal> getAllAnimals(){
        return animalService.getAllAnimals();
    }

    @PutMapping("{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable("id") long id, @RequestBody Animal animal){
        return new ResponseEntity<Animal>(animalService.updateAnimal(animal,id),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAnimal(@PathVariable("id") long id){
        animalService.deleteAnimal(id);
        return new ResponseEntity<String>("Animal deleted successfully",HttpStatus.OK);
    }
    @GetMapping("/findBy")
    public List<Animal> findAnimals(HttpServletRequest request) {
        return animalService.findAnimals(request);
    }
}

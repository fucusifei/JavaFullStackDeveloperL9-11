package com.yevdokymov.JavaFullStackDeveloperL911.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yevdokymov.JavaFullStackDeveloperL911.JavaFullStackDeveloperL911Application;
import com.yevdokymov.JavaFullStackDeveloperL911.model.Animal;
import com.yevdokymov.JavaFullStackDeveloperL911.repository.AnimalRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = JavaFullStackDeveloperL911Application.class)
@AutoConfigureMockMvc
class AnimalControllerTest {
    private final String name = "qwe";
    private final String kindOfAnimal = "123124";
    private final String gender = "m";
    private final int age = 12;
    private final int height = 12;
    private final int length = 12;
    private final int weight = 12;
    String issueDate = "12.04.2001";
    @Autowired
    private MockMvc mvc;
    @Autowired
    private AnimalRepository animalRepository;

    public String newAnimal(){

        return """
                {
                   "name": "%s",
                   "kindOfAnimal": "%s",
                   "gender" : "%s",
                   "age" : %d,
                   "height" : %d,
                   "length" : %d,
                   "weight" : %d,
                   "issueDate" : "%s"
                }             
                """.formatted(name,kindOfAnimal,gender,age,height,length,weight,issueDate);
    }

    @Test
    void createAnimal() throws Exception {

        mvc.perform(MockMvcRequestBuilders.post("/api/animals")
                        .content(newAnimal()).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated()).andReturn();
        Animal animal = animalRepository.findById(1L).orElse(null);
        assert animal != null;
        assertEquals(animal.getName(),name);
        assertEquals(animal.getKindOfAnimal(),kindOfAnimal);
        assertEquals(animal.getGender(),gender);
        assertEquals(animal.getAge(),age);
        assertEquals(animal.getHeight(),height);
        assertEquals(animal.getLength(),length);
        assertEquals(animal.getWeight(),weight);
        assertEquals(animal.getIssueDate(),issueDate);

    }

    @Test
    void getAllAnimals() throws Exception {
        mvc.perform((MockMvcRequestBuilders.get("/api/animals").accept(MediaType.APPLICATION_JSON))).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void updateAnimal() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/api/animals")
                        .content(newAnimal()).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated());
        mvc.perform(MockMvcRequestBuilders.put("/api/animals/{id}",1)
                        .content("""
                {
                   "name": "adam",
                   "kindOfAnimal": "dog",
                   "gender" : "m",
                   "age" : 2,
                   "height" : 3,
                   "length" : 1,
                   "weight" : 1,
                   "issueDate" : "12.04.2001"
                }             
                """).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
        Animal animal = animalRepository.findById(1L).orElse(null);
        assert animal != null;
        assertEquals(animal.getName(),"adam");
        assertEquals(animal.getKindOfAnimal(),"dog");
        assertEquals(animal.getGender(),"m");
        assertEquals(animal.getAge(),2);
        assertEquals(animal.getHeight(),3);
        assertEquals(animal.getLength(),1);
        assertEquals(animal.getWeight(),1);
        assertEquals(animal.getIssueDate(),"12.04.2001");
    }

    @Test
    void deleteAnimal() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/api/animals")
                        .content(newAnimal()).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated());
        mvc.perform(MockMvcRequestBuilders.delete("/api/animals/{id}", 1) )
                .andExpect(status().isOk());
        Animal animal = animalRepository.findById(1L).orElse(null);
        assert animal == null;
    }
    @Test
    void findAnimals() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/api/animals")
                        .content(newAnimal()).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated());

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/api/animals/findBy?name=qwe&age=12")
                .accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk()).andReturn();

    }

}
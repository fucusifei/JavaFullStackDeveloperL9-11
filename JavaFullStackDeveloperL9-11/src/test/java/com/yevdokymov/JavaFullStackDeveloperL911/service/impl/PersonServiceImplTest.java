package com.yevdokymov.JavaFullStackDeveloperL911.service.impl;

import com.yevdokymov.JavaFullStackDeveloperL911.JavaFullStackDeveloperL911Application;
import com.yevdokymov.JavaFullStackDeveloperL911.model.PersonThatSheltered;
import com.yevdokymov.JavaFullStackDeveloperL911.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = JavaFullStackDeveloperL911Application.class)
@AutoConfigureMockMvc
class PersonServiceImplTest {
    private String fullName = "qwe";
    private String mobileNumber = "960058353";
    private String sex = "m";
    private String address = "123244";
    @Autowired
    PersonRepository personRepository;
    public String newPerson(){

        return """
                {
                    "fullName": "%s",
                    "mobileNumber": "%s",
                    "sex" : "%s",
                    "address" : "%s"
                }            
                """.formatted(fullName,mobileNumber,sex,address);
    }
    @Autowired
    private MockMvc mvc;
    @Test
    void createPerson() throws Exception {

        mvc.perform(MockMvcRequestBuilders.post("/api/persons")
                        .content(newPerson()).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated()).andReturn();
        PersonThatSheltered person = personRepository.findById(1L).orElse(null);
        assert person != null;
        assertEquals(person.getFullName(),fullName);
        assertEquals(person.getMobileNumber(),mobileNumber);
        assertEquals(person.getSex(),sex);
        assertEquals(person.getAddress(),address);
        }

    @Test
    void getAllPersons() throws Exception {
        mvc.perform((MockMvcRequestBuilders.get("/api/persons").accept(MediaType.APPLICATION_JSON))).andDo(print()).andExpect(status().isOk());
    }
}
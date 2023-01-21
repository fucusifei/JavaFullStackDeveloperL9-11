package com.yevdokymov.JavaFullStackDeveloperL911.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="person_that_sheltered")
public class PersonThatSheltered {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;

    @Column(name = "sex")
    private String sex;

    @Column(name = "age")
    private int age;

    @Column(name = "address", nullable = false)
    private String address;
}

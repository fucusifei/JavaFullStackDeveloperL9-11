package com.yevdokymov.JavaFullStackDeveloperL911.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "kind_of_animal", nullable = false)
    private String kindOfAnimal;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "height", nullable = false)
    private int height;

    @Column(name = "length", nullable = false)
    private int length;

    @Column(name = "weight", nullable = false)
    private int weight;

    @Column(name = "issue_date", nullable = false)
    private String issueDate;

    @Column(name = "receiving_date")
    private String receivingDate;

    @ManyToOne
    @JoinColumn(name = "id_person")
    private PersonThatSheltered personThatSheltered;

}

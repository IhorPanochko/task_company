package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Person {


    public Person() {
    }

    public Person(String name, String secondName, String email, String phone, Project project, Department department, Position position) {
        this.name = name;
        this.secondName = secondName;
        this.email = email;
        this.phone = phone;
        this.project = project;
        this.department = department;
        this.position = position;
    }

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name = "id")
     private Long id;

     @Column(length = 20, nullable = false)
     private String name;

     @Column(length = 20, nullable = false)
     private String secondName;

     @Column(length = 20, nullable = false,unique = true)
     private String email;

     @Column(length = 20, nullable = false)
     private String phone;


    @ManyToOne
    @JoinColumn(name = "project")
    @JsonManagedReference
    private Project project;

    @ManyToOne
    @JoinColumn(name = "department")
    @JsonManagedReference
    private Department department;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id",referencedColumnName = "id")
    @JsonIgnore
    private Position position;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", project=" + project +
                '}';
    }



}

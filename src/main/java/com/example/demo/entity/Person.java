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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

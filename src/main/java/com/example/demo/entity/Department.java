package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Department {

    public Department() {
    }

    public Department(String name, Company company) {
        this.name = name;
        this.company = company;
    }

    public Department(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;


    @ManyToOne
    @JoinColumn(name = "company",nullable = false)
    @JsonManagedReference
    private Company company;


    @OneToMany(mappedBy = "department")
    @JsonBackReference
    private List<Position> positions;

    @OneToMany(mappedBy = "department")
    @JsonBackReference
    private List<Person>people;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company=" + company +
                '}';
    }


}

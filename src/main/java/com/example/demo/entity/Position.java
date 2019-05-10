package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Position {

    public Position() {
    }

    public Position(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "department")
    @JsonManagedReference
    private Department department;

    @OneToOne(mappedBy = "position")
    @JsonManagedReference
    private Person person;


    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
                ", person=" + person +
                '}';
    }



}

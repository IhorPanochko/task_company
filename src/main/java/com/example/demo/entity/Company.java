package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Company {

    public Company(String name, String address, String email, String postCode) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.postCode = postCode;
    }

    public Company() {
    }

    @OneToMany(mappedBy = "company")
    @JsonBackReference
    private List<Department>departments;



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(length = 20, nullable = false, unique = true)
    private String name;
    @Column(length = 20, nullable = false)
    private String address;
    @Column(length = 20, nullable = false,unique = true)
    private String email;
    @Column(length = 20, nullable = false)
    private String postCode;

    @OneToMany(mappedBy = "company")
    @JsonBackReference
    private List<Project>projects;

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }


}

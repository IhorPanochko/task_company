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

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}

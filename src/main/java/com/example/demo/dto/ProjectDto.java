package com.example.demo.dto;


import lombok.Data;

@Data
public class ProjectDto {


    public ProjectDto() {
    }

    private Long id;

    private String name;

    private Long companyId;


}

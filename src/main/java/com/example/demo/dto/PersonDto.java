package com.example.demo.dto;

import lombok.Data;

@Data
public class PersonDto {


    public PersonDto() {
    }

    private Long id;

    private String name;

    private String secondName;

    private String email;

    private String phone;

    private Long positionId;

    private Long companyId;

    private Long projectId;

    private Long departmentId;


}

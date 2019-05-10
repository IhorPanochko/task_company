package com.example.demo.dto;

import lombok.Data;

@Data
public class PositionDto {

    public PositionDto() {
    }

    private Long id;

    private String name;

    private Long departmentId;


}

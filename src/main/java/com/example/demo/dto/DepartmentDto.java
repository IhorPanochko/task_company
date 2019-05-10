package com.example.demo.dto;

import lombok.Data;

@Data
public class DepartmentDto {

    private Long id;

    private String name;

    private Long companyId;

    public DepartmentDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

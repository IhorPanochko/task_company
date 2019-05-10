package com.example.demo.controller;


import com.example.demo.dto.DepartmentDto;
import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping()
    public ResponseEntity createDepartment(@RequestBody DepartmentDto departmentDto){
         departmentService.creat(departmentDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDepartment(@PathVariable Long id){
         departmentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable Long id){
        return new ResponseEntity<>(departmentService.getById(id),HttpStatus.ACCEPTED);
    }

    @PutMapping()
    public ResponseEntity editDepartment(@RequestBody DepartmentDto departmentDto){
         departmentService.update(departmentDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}

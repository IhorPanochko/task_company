package com.example.demo.service.implementation;


import com.example.demo.dto.PositionDto;
import com.example.demo.entity.Department;
import com.example.demo.entity.Position;
import com.example.demo.repository.*;
import com.example.demo.service.PositionService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {


    @Autowired
    private DepartmentRepository departmentRepository;


    @Autowired
    private PositionRepository positionRepository;

    @Override
    public void create(PositionDto position) {
     positionRepository.save(new Position(position.getName(),departmentRepository.getOne(position.getDepartmentId())));
    }

    @Override
    public void create(Position position, Department department) {
        List<Position>positions=department.getPositions();
        positions.add(position);
        departmentRepository.save(department);
    }

    @Override
    public void delete(Position position) {
        positionRepository.delete(position);
    }

    @Override
    public void delete(Long id) {
      positionRepository.deleteById(id);
    }


    @Override
    public Position findById(Long id) {
        return positionRepository.getOne(id);
    }

    @Override
    public void update(PositionDto position) {
        Position position1=positionRepository.getOne(position.getId());
        position1.setName(position.getName());
        position1.setDepartment(departmentRepository.getOne(position.getDepartmentId()));
        positionRepository.save(position1);
    }
}

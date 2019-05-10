package com.example.demo.service;


import com.example.demo.dto.PositionDto;
import com.example.demo.entity.Department;
import com.example.demo.entity.Position;
import javafx.geometry.Pos;

import java.util.List;

public interface PositionService {

    void create(PositionDto position);

    void create(Position position, Department department);

    void delete(Position position);

    void delete(Long id);



    Position findById(Long id);

    void update(PositionDto position);

}

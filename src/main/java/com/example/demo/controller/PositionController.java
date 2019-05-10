package com.example.demo.controller;

import com.example.demo.dto.PositionDto;
import com.example.demo.entity.Position;
import com.example.demo.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @PostMapping()
    public ResponseEntity createPosition(@RequestBody PositionDto positionDto){
        positionService.create(positionDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePosition(@PathVariable Long id){
        positionService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Position> getPosition(@PathVariable Long id){
        return new ResponseEntity<>(positionService.findById(id), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity updatePosition(@RequestBody PositionDto positionDto){
        positionService.update(positionDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

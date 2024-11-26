package com.week2.Week2HomeWork.controllers;

import com.week2.Week2HomeWork.dtos.DepartmentDto;
import com.week2.Week2HomeWork.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/departments")
public class departmentController {

    private final DepartmentService departmentService;

    departmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping()
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable Long departmentId){
        return ResponseEntity.ok(departmentService.getDepartmentById(departmentId));
    }

    @PostMapping()
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody @Valid DepartmentDto departmentDto){
        return new ResponseEntity<>(departmentService.createDepartment(departmentDto), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDto> updateDepartmentById(@PathVariable Long departmentId , @RequestBody @Valid DepartmentDto departmentDto){
        return ResponseEntity.ok(departmentService.updateDepartmentById(departmentId , departmentDto));
    }

    @DeleteMapping(path = "/{departmentId}")
    public ResponseEntity<Boolean> deleteDepartmentById(@PathVariable Long departmentId){
        return ResponseEntity.ok(departmentService.deleteDepartmentById(departmentId));
    }
}

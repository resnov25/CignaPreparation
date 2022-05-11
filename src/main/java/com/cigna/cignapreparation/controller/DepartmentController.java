package com.cigna.cignapreparation.controller;

import com.cigna.cignapreparation.entity.Department;
import com.cigna.cignapreparation.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNullFields;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> postDepartment(@PathVariable String department, @PathVariable(value = "0") Integer numberEmployees){
        return new ResponseEntity<Department>(departmentService.postDepartment(department, numberEmployees),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Department>> getDepartments(){
        return new ResponseEntity<List<Department>>(departmentService.getDepartmentsByNumberEmployees(),HttpStatus.OK);
    }
}

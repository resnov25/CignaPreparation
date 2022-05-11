package com.cigna.cignapreparation.service;

import com.cigna.cignapreparation.entity.Department;
import com.cigna.cignapreparation.repository.DepartmentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRespository departmentRespository;

    public Department postDepartment(String department, Integer numberEmployees) {
        Optional<Department> departmentOptional = departmentRespository.findByName(department);
        if (departmentOptional.isPresent()){
            throw new ResponseStatusException(String.format("El departamento %s ya existe", department), HttpStatus.FOUND);
        }else{
            Department department1 = Department.builder()
                    .name(department)
                    .numberEmployees(numberEmployees)
                    .build();
            return departmentRespository.save(department1);
        }
    }

    public List<Department> getDepartmentsByNumberEmployees() {
        List<Department> departmentList = departmentRespository.findAll();
        departmentList.stream().filter(department -> department.);
    }
}

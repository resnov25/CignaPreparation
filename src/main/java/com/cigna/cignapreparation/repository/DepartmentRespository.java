package com.cigna.cignapreparation.repository;

import com.cigna.cignapreparation.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRespository extends JpaRepository<Department, Integer> {

    Optional<Department> findByName(String name);

}

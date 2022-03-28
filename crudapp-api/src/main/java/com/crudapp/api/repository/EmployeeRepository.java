package com.crudapp.api.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.crudapp.api.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
	
	Optional<Employee> findByEmail(String email);

}

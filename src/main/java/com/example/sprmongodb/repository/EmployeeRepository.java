package com.example.sprmongodb.repository;

import com.example.sprmongodb.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository <Employee, Long>{

}

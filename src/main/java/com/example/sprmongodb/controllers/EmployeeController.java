package com.example.sprmongodb.controllers;

import com.example.sprmongodb.exception.ResourceNotFoundException;
import com.example.sprmongodb.model.Employee;
import com.example.sprmongodb.repository.EmployeeRepository;
import com.example.sprmongodb.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import javax.validation.Valid;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    // Aplicando as injeções de dependencia.
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    //Construção das requisições http

    //Método para criar todos os registros encontrados.
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //Método para trazer um unico registro se assim for solicitado.
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException{
            Employee employee = employeeRepository.findById(employeeId)
                    .orElseThrow(()-> new ResourceNotFoundException("Colaborador não encontrado: " + employeeId));
            return ResponseEntity.ok().body(employee);
    }

    // Método para criar os registros no DB
    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee){
        employee.setId(sequenceGeneratorService.generateSequence(Employee.SEQUENCE_NAME));

        return employeeRepository.save(employee);
    }

    //Método para atualizar os registros
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                   @Valid @RequestBody Employee employeeDetails)
            throws ResourceNotFoundException{
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("Colaborador, não encontrado para esse ID: " + employeeId));

        employee.setEmailId(employeeDetails.getEmailId());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        final Employee updateEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok().body(updateEmployee);
    }
}

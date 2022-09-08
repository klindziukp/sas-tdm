package com.klindziuk.sas.tdm.gen.controller;

import com.klindziuk.sas.tdm.database.repository.EmployeeRepository;
import com.klindziuk.sas.tdm.database.domain.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

  private final EmployeeRepository employeeRepository;

  @Autowired
  public EmployeeController(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @GetMapping(value = "api/v1/employees", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Employee>> employees() {
    return ResponseEntity.ok(employeeRepository.findAll());
  }
}

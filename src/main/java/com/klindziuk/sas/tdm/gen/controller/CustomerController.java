package com.klindziuk.sas.tdm.gen.controller;

import com.klindziuk.sas.tdm.database.repository.CustomerRepository;
import com.klindziuk.sas.tdm.database.domain.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

  private final CustomerRepository customerRepository;

  @Autowired
  public CustomerController(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @GetMapping(value = "api/v1/customers", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Customer>> customers() {
    return ResponseEntity.ok(customerRepository.findAll());
  }
}

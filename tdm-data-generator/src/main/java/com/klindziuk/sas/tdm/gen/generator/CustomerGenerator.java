package com.klindziuk.sas.tdm.gen.generator;

import com.klindziuk.sas.tdm.database.domain.Customer;
import com.klindziuk.sas.tdm.database.domain.Employee;
import com.klindziuk.sas.tdm.database.repository.CustomerRepository;
import com.klindziuk.sas.tdm.gen.config.generator.GeneratorConfig;
import com.klindziuk.sas.tdm.gen.generator.model.CustomerModelGenerator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerGenerator {

  private final CustomerRepository customerRepository;
  private final CustomerModelGenerator customerModelGenerator;
  private final GeneratorConfig generatorConfig;

  @Autowired
  public CustomerGenerator(
      CustomerRepository customerRepository,
      CustomerModelGenerator customerModelGenerator,
      GeneratorConfig generatorConfig) {
    this.customerRepository = customerRepository;
    this.customerModelGenerator = customerModelGenerator;
    this.generatorConfig = generatorConfig;
  }

  public List<Customer> generateCustomers(List<Employee> employees) {
    List<Customer> existingCustomers = customerRepository.findAll();
    return customerRepository.saveAllAndFlush(
        customerModelGenerator.getCustomers(itemsToGenerate(), existingCustomers, employees));
  }

  private long itemsToGenerate() {
    return generatorConfig.customer().getSize() > 0 ? generatorConfig.customer().getSize() : 1;
  }
}

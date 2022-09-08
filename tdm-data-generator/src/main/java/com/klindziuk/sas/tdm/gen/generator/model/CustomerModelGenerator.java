package com.klindziuk.sas.tdm.gen.generator.model;

import com.klindziuk.sas.tdm.database.domain.Customer;
import com.klindziuk.sas.tdm.database.domain.Employee;
import com.klindziuk.sas.tdm.database.domain.Product;
import com.klindziuk.sas.tdm.gen.util.RandomUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CustomerModelGenerator {

  public List<Customer> getCustomers(long size, List<Customer> existingCustomers, List<Employee> employees) {
    Collections.reverse(existingCustomers);
    int customerStartId = existingCustomers.isEmpty() ? 0 : existingCustomers.get(0).getCustomerNumber();
    int syntheticEmployeeId = customerStartId + 10;
    List<Customer> result = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      syntheticEmployeeId++;
      result.add(customer(syntheticEmployeeId, RandomUtil.getRandomElement(employees)));
    }
    return result;
  }

  public Customer customer(int customerId, Employee employee) {
    return new Customer()
        .setCustomerNumber(customerId)
        .setCustomerName(RandomUtil.generateStringField("name", 12))
        .setContactLastName(RandomUtil.generateStringField("last", 12))
        .setContactFirstName(RandomUtil.generateStringField("first", 12))
        .setPhone(RandomUtil.generateStringField("phone", 7))
        .setAddressLine1(RandomUtil.generateStringField("line-1", 12))
        .setAddressLine2(RandomUtil.generateStringField("line-2", 12))
        .setCity(RandomUtil.generateStringField("otso-city", 12))
        .setState(RandomUtil.generateStringField("of-mind", 8))
        .setPostalCode(RandomUtil.generateStringField("c", 6))
        .setCountry(RandomUtil.generateStringField("free", 5))
        .setSalesEmployee(employee)
        .setSalesRepEmployeeNumber(employee.getEmployeeNumber())
        .setCreditLimit(29000.00);
  }

  public Product generateProductWithNullField(List<String> nullFields) {
    // TODO use reflection to get name for fields
    return new Product();
  }
}

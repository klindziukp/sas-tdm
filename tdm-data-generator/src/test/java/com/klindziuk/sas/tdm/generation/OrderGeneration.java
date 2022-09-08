package com.klindziuk.sas.tdm.generation;

import com.klindziuk.sas.tdm.DataBaseInteraction;
import com.klindziuk.sas.tdm.database.domain.Customer;
import com.klindziuk.sas.tdm.database.domain.Employee;
import com.klindziuk.sas.tdm.database.domain.Office;
import java.util.List;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;

public class OrderGeneration extends DataBaseInteraction {

  public static final Logger LOGGER = LoggerFactory.getLogger(OrderGeneration.class);

  @Test
  @Rollback(false)
  @Tag("generate-orders")
  public void generateOrders() {
    LOGGER.info("Generating 'Order' items");
    cleanupDatabase();
    insertRealData();
    List<Office> offices = officeGenerator.generateOfficeItems();
    List<Employee> employees = employeeGenerator.generateEmployees(offices);
    List<Customer> customers = customerGenerator.generateCustomers(employees);
    orderGenerator.generateOrders(customers);
  }
}

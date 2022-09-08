package com.klindziuk.sas.tdm.generation;

import com.klindziuk.sas.tdm.DataBaseInteraction;
import com.klindziuk.sas.tdm.database.domain.Customer;
import com.klindziuk.sas.tdm.database.domain.Employee;
import com.klindziuk.sas.tdm.database.domain.Office;
import com.klindziuk.sas.tdm.database.domain.Order;
import com.klindziuk.sas.tdm.database.domain.Product;
import com.klindziuk.sas.tdm.database.domain.ProductLineItem;
import java.util.List;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;

public class OrderDetailGeneration extends DataBaseInteraction {

  public static final Logger LOGGER = LoggerFactory.getLogger(OrderDetailGeneration.class);

  @Test
  @Rollback(false)
  @Tag("generate-order-details")
  public void generateOrderDetails() {
    LOGGER.info("Generating 'Order detail' items");
    cleanupDatabase();
    insertRealData();
    List<Office> offices = officeGenerator.generateOfficeItems();
    List<Employee> employees = employeeGenerator.generateEmployees(offices);
    List<Customer> customers = customerGenerator.generateCustomers(employees);
    List<Order> orders = orderGenerator.generateOrders(customers);
    List<ProductLineItem> productLineItems = productLineGenerator.generateProductLineItems();
    List<Product> products = productGenerator.generateProductItems(productLineItems);
    orderDetailGenerator.generateOrderDetails(orders, products);
  }
}

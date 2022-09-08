package com.klindziuk.sas.tdm.gen.api;

import com.klindziuk.sas.tdm.database.domain.Customer;
import com.klindziuk.sas.tdm.database.domain.Employee;
import com.klindziuk.sas.tdm.database.domain.Office;
import com.klindziuk.sas.tdm.database.domain.Order;
import com.klindziuk.sas.tdm.database.domain.OrderDetail;
import com.klindziuk.sas.tdm.database.domain.Payment;
import com.klindziuk.sas.tdm.database.domain.Product;
import com.klindziuk.sas.tdm.database.domain.ProductLineItem;
import com.klindziuk.sas.tdm.gen.config.generator.GeneratorConfig;
import com.klindziuk.sas.tdm.gen.generator.CustomerGenerator;
import com.klindziuk.sas.tdm.gen.generator.EmployeeGenerator;
import com.klindziuk.sas.tdm.gen.generator.OfficeGenerator;
import com.klindziuk.sas.tdm.gen.generator.OrderDetailGenerator;
import com.klindziuk.sas.tdm.gen.generator.OrderGenerator;
import com.klindziuk.sas.tdm.gen.generator.PaymentGenerator;
import com.klindziuk.sas.tdm.gen.generator.ProductGenerator;
import com.klindziuk.sas.tdm.gen.generator.ProductLineGenerator;
import com.klindziuk.sas.tdm.gen.sql.SqlScriptExecutor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneratorController {

  @Autowired protected SqlScriptExecutor sqlScriptExecutor;
  @Autowired protected EmployeeGenerator employeeGenerator;
  @Autowired protected ProductLineGenerator productLineGenerator;
  @Autowired protected OfficeGenerator officeGenerator;
  @Autowired protected OrderGenerator orderGenerator;
  @Autowired protected OrderDetailGenerator orderDetailGenerator;
  @Autowired protected CustomerGenerator customerGenerator;
  @Autowired protected ProductGenerator productGenerator;
  @Autowired protected PaymentGenerator paymentGenerator;
  @Autowired protected GeneratorConfig generatorConfig;

  @PostMapping(value = "api/v1/cleanup", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> cleanup() {
    sqlScriptExecutor.cleanupDatabase();
    return ResponseEntity.ok("Database cleanup performed successfully");
  }

  @PostMapping(value = "api/v1/generate", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> generate() {
    generateDatabaseItems();
    return ResponseEntity.ok("Database item generation performed successfully");
  }

  @PostMapping(value = "api/v1/generate-with-real-data", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> generateWithRealData() {
    sqlScriptExecutor.cleanupDatabase();
    if (generatorConfig.getIsRealDataEnabled()) {
      sqlScriptExecutor.insertRealData();
    }
    generateDatabaseItems();
    return ResponseEntity.ok("Database item generation with real performed successfully");
  }

  private void generateDatabaseItems(){
    List<ProductLineItem> productLineItems = productLineGenerator.generateProductLineItems();
    List<Product> products = productGenerator.generateProductItems(productLineItems);
    List<Office> offices = officeGenerator.generateOfficeItems();
    List<Employee> employees = employeeGenerator.generateEmployees(offices);
    List<Customer> customers = customerGenerator.generateCustomers(employees);
    List<Payment> payments = paymentGenerator.generatePaymentItems(customers);
    List<Order> orders = orderGenerator.generateOrders(customers);
    List<OrderDetail> orderDetails = orderDetailGenerator.generateOrderDetails(orders, products);
  }
}

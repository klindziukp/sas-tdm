package com.klindziuk.sas.tdm.gen.config.generator;

import com.klindziuk.sas.tdm.gen.config.generator.table.CustomerConfig;
import com.klindziuk.sas.tdm.gen.config.generator.table.EmployeeConfig;
import com.klindziuk.sas.tdm.gen.config.generator.table.OfficeConfig;
import com.klindziuk.sas.tdm.gen.config.generator.table.OrderConfig;
import com.klindziuk.sas.tdm.gen.config.generator.table.OrderDetailConfig;
import com.klindziuk.sas.tdm.gen.config.generator.table.PaymentConfig;
import com.klindziuk.sas.tdm.gen.config.generator.table.ProductConfig;
import com.klindziuk.sas.tdm.gen.config.generator.table.ProductLineConfig;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Data
@Import({EmployeeConfig.class,
    EmployeeConfig.class,
    CustomerConfig.class,
    OfficeConfig.class,
    OrderConfig.class,
    OrderDetailConfig.class,
    PaymentConfig.class,
    ProductConfig.class,
    ProductLineConfig.class
})
public class GeneratorConfig {

  @Value("${generator.real-data-enabled:false}")
  private Boolean isRealDataEnabled;

  @Autowired  private EmployeeConfig employeeConfig;
  @Autowired  private CustomerConfig customerConfig;
  @Autowired  private OfficeConfig officeConfig;
  @Autowired  private OrderConfig orderConfig;
  @Autowired  private OrderDetailConfig orderDetailConfig;
  @Autowired  private PaymentConfig paymentConfig;
  @Autowired  private ProductConfig productConfig;
  @Autowired  private ProductLineConfig productLineConfig;

  public EmployeeConfig employee() {
    return employeeConfig;
  }

  public CustomerConfig customer() {
    return customerConfig;
  }

  public OfficeConfig office() {
    return officeConfig;
  }

  public OrderConfig order() {
    return orderConfig;
  }

  public OrderDetailConfig orderDetail() {
    return orderDetailConfig;
  }

  public PaymentConfig payment() {
    return paymentConfig;
  }

  public ProductConfig product() {
    return productConfig;
  }

  public ProductLineConfig productLine() {
    return productLineConfig;
  }

}

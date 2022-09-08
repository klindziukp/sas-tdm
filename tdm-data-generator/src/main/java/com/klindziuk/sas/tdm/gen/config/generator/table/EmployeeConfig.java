package com.klindziuk.sas.tdm.gen.config.generator.table;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class EmployeeConfig {

  @Value("${generator.employee.simple-generation-size:10}")
  private int size;

  @Value("${generator.employee.percentage-calculation:false}")
  private Boolean isPercentageCalculationEnabled;

  @Value("${generator.employee.synthetic-percentage:50}")
  private int syntheticPercentage;

  @Value("${generator.employee.invalid-percentage:0}")
  private int invalidPercentage;

}

package com.klindziuk.sas.tdm.gen.config.generator.table;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class ProductLineConfig {

  @Value("${generator.product-line.simple-generation-size:10}")
  private int size;

  @Value("${generator.product-line.synthetic-percentage:50}")
  private int syntheticPercentage;

  @Value("${generator.product-line.invalid-percentage:0}")
  private int invalidPercentage;

}

package com.klindziuk.sas.tdm.gen.config.generator.table;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class ProductConfig {

  @Value("${generator.product.simple-generation-size:10}")
  private int size;

  @Value("${generator.product.synthetic-percentage:50}")
  private int syntheticPercentage;

  @Value("${generator.product.invalid-percentage:0}")
  private int invalidPercentage;

}

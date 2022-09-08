package com.klindziuk.sas.tdm.gen.config.generator.table;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class OrderDetailConfig {

  @Value("${generator.order-detail.simple-generation-size:10}")
  private int size;

  @Value("${generator.order-detail.synthetic-percentage:50}")
  private int syntheticPercentage;

  @Value("${generator.order-detail.invalid-percentage:0}")
  private int invalidPercentage;

}

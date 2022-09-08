package com.klindziuk.sas.tdm.generation;

import com.klindziuk.sas.tdm.DataBaseInteraction;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;

public class ProductLineItemGeneration extends DataBaseInteraction {

  public static final Logger LOGGER = LoggerFactory.getLogger(ProductLineItemGeneration.class);

  @Test
  @Rollback(false)
  @Tag("generate-product-lines")
  public void generateProductLines()  {
    LOGGER.info("Generating 'Product line' items");
    cleanupDatabase();
    insertRealData();
    productLineGenerator.generateProductLineItems();
  }
}

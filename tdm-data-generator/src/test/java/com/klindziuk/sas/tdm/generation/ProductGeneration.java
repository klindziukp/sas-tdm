package com.klindziuk.sas.tdm.generation;

import com.klindziuk.sas.tdm.DataBaseInteraction;
import com.klindziuk.sas.tdm.database.domain.ProductLineItem;
import java.util.List;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;

public class ProductGeneration extends DataBaseInteraction {

  public static final Logger LOGGER = LoggerFactory.getLogger(ProductGeneration.class);

  @Test
  @Rollback(false)
  @Tag("generate-products")
  public void generateProduct()  {
    LOGGER.info("Generating 'Product' items");
    cleanupDatabase();
    insertRealData();
    List<ProductLineItem> productLineItems = productLineGenerator.generateProductLineItems();
    productGenerator.generateProductItems(productLineItems);
  }
}

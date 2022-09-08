package com.klindziuk.sas.tdm.generation;

import com.klindziuk.sas.tdm.DataBaseInteraction;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;

public class OfficeItemGeneration extends DataBaseInteraction {

  public static final Logger LOGGER = LoggerFactory.getLogger(OfficeItemGeneration.class);

  @Test
  @Tag("generate-offices")
  @Rollback(false)
  public void generateOffices()  {
    LOGGER.info("Generating 'Office' items");
    cleanupDatabase();
    insertRealData();
    officeGenerator.generateOfficeItems();
  }
}

package com.klindziuk.sas.tdm.generation;

import com.klindziuk.sas.tdm.DataBaseInteraction;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;

public class InsertRealData extends DataBaseInteraction {

  public static final Logger LOGGER = LoggerFactory.getLogger(InsertRealData.class);

  @Test
  @Tag("insert-real-data")
  @Rollback(false)
  public void generateOffice()  {
    LOGGER.info("Inserting real data from sql script");
    cleanupDatabase();
    insertRealData();
  }
}

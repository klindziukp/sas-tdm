package com.klindziuk.sas.tdm.generation;

import com.klindziuk.sas.tdm.DataBaseInteraction;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;

public class Cleanup extends DataBaseInteraction {

  public static final Logger LOGGER = LoggerFactory.getLogger(Cleanup.class);

  @Test
  @Tag("cleanup")
  @Rollback(false)
  public void cleanupAll() {
    LOGGER.info("Removing all items from database");
    cleanupDatabase();
  }
}

package com.klindziuk.sas.tdm.generation;

import com.klindziuk.sas.tdm.DataBaseInteraction;
import com.klindziuk.sas.tdm.database.domain.Office;
import java.util.List;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;

public class EmployeeGeneration extends DataBaseInteraction {

  public static final Logger LOGGER = LoggerFactory.getLogger(EmployeeGeneration.class);

  @Test
  @Rollback(false)
  @Tag("generate-employee")
  public void generateEmployee()  {
    LOGGER.info("Generating 'Employee' items");
    cleanupDatabase();
    insertRealData();
    List<Office> offices = officeGenerator.generateOfficeItems();
    employeeGenerator.generateEmployees(offices);

  }
}

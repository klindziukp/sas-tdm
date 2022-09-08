package com.klindziuk.sas.tdm;

import com.klindziuk.sas.tdm.database.config.JpaRepositoryConfig;
import com.klindziuk.sas.tdm.gen.generator.EmployeeGenerator;
import com.klindziuk.sas.tdm.gen.generator.PaymentGenerator;
import com.klindziuk.sas.tdm.gen.sql.SqlScriptExecutor;
import com.klindziuk.sas.tdm.gen.config.generator.GeneratorConfig;
import com.klindziuk.sas.tdm.gen.generator.CustomerGenerator;
import com.klindziuk.sas.tdm.gen.generator.OfficeGenerator;
import com.klindziuk.sas.tdm.gen.generator.OrderDetailGenerator;
import com.klindziuk.sas.tdm.gen.generator.OrderGenerator;
import com.klindziuk.sas.tdm.gen.generator.ProductGenerator;
import com.klindziuk.sas.tdm.gen.generator.ProductLineGenerator;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { JpaRepositoryConfig.class })
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public abstract class DataBaseInteraction {

  public static final Logger LOGGER = LoggerFactory.getLogger(DataBaseInteraction.class);

  @Autowired protected SqlScriptExecutor sqlScriptExecutor;
  @Autowired protected EmployeeGenerator employeeGenerator;
  @Autowired protected ProductLineGenerator productLineGenerator;
  @Autowired protected OfficeGenerator officeGenerator;
  @Autowired protected OrderGenerator orderGenerator;
  @Autowired protected OrderDetailGenerator orderDetailGenerator;
  @Autowired protected CustomerGenerator customerGenerator;
  @Autowired protected ProductGenerator productGenerator;
  @Autowired protected PaymentGenerator paymentGenerator;
  @Autowired protected GeneratorConfig generatorConfig;

  protected void insertRealData() {
    LOGGER.info("Inserting real data");
    if (generatorConfig.getIsRealDataEnabled()) {
        sqlScriptExecutor.insertRealData();
    }
  }

  protected void cleanupDatabase() {
    LOGGER.info("Cleaning up database");
      sqlScriptExecutor.cleanupDatabase();
  }
}

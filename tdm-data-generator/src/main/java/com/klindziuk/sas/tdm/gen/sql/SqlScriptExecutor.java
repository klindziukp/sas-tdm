package com.klindziuk.sas.tdm.gen.sql;

import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SqlScriptExecutor {

  public static final Logger LOGGER = LoggerFactory.getLogger(SqlScriptExecutor.class);

  private final DataSource dataSource;

  @Autowired
  public SqlScriptExecutor(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public void cleanupDatabase() {
    executeSqsScript("/script/001_clean.sql");
  }

  public void insertRealData() {
    executeSqsScript("/script/002_real_data.sql");
  }

  private void executeSqsScript(String location) {
    LOGGER.info("Executing sql script from location '{}'", location);
    ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
    PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    Resource resource = resolver.getResource(location);
    resourceDatabasePopulator.addScript(resource);
    resourceDatabasePopulator.execute(dataSource);
  }
}

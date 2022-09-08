package com.klindziuk.sas.tdm.gen;

import com.klindziuk.sas.tdm.database.config.JpaRepositoryConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(JpaRepositoryConfig.class)
public class GenApplication {

  public static void main(String[] args) {
    SpringApplication.run(GenApplication.class, args);
  }

}

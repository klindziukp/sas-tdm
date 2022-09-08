package com.klindziuk.sas.tdm.gen.api;

import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

public class OfficeService {

  public OfficeService() {
  }

  public OfficeClient officeClient() {
    return Feign.builder()
        .client(new OkHttpClient())
        .encoder(new JacksonEncoder())
        .decoder(new JacksonDecoder())
        .logger(new Slf4jLogger(OfficeClient.class))
        .logLevel(Logger.Level.FULL)
        .target(OfficeClient.class, "http://localhost:8080/api/v1/offices");
  }

}

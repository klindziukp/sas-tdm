package com.klindziuk.sas.tdm.gen.api;

import com.klindziuk.sas.tdm.gen.response.Office;
import feign.RequestLine;

public interface OfficeClient {

  @RequestLine("GET")
  Office[] officeResponse();

}
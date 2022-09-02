package com.klindziuk.sas.tdm.api;

import com.klindziuk.sas.tdm.response.Office;
import com.klindziuk.sas.tdm.response.OfficeResponse;
import feign.RequestLine;
import java.util.List;

public interface OfficeClient {

  @RequestLine("GET")
  Office[] officeResponse();

}
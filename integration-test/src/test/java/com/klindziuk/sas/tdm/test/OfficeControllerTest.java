package com.klindziuk.sas.tdm.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.klindziuk.sas.tdm.api.OfficeService;
import com.klindziuk.sas.tdm.response.Office;
import org.junit.jupiter.api.Test;

public class OfficeControllerTest {

  @Test
  public void verifyOfficeController()  {
    Office[] offices = new OfficeService().officeClient().officeResponse();
    assertEquals(7, offices.length);
  }

}

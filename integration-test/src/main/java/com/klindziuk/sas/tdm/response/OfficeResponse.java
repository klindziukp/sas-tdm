package com.klindziuk.sas.tdm.response;

import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class OfficeResponse {

  Office[] offices;

  public List<Office> getOffices() {
    return List.of(offices);
  }
}

package com.klindziuk.sas.tdm.gen.generator.model;

import com.klindziuk.sas.tdm.database.domain.Office;
import com.klindziuk.sas.tdm.database.domain.ProductLineItem;
import com.klindziuk.sas.tdm.gen.util.RandomUtil;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OfficeModelGenerator {

  public List<Office> getOffices(long size) {
    List<Office> result = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      result.add(office());
    }
    return result;
  }

  public Office office() {
    return new Office()
        .setOfficeCode(RandomUtil.generateStringField("c",8).toLowerCase())
        .setCity(RandomUtil.generateStringField("otso-city", 12))
        .setPhone(RandomUtil.generateStringField("+375", 10))
        .setAddressLine1(RandomUtil.generateStringField("address-line-1", 12))
        .setAddressLine2(RandomUtil.generateStringField("address-line-2", 12))
        .setState(RandomUtil.generateStringField("state", 12))
        .setCountry(RandomUtil.generateStringField("country-", 12))
        .setPostalCode(RandomUtil.generateStringField("p-c", 6))
        .setTerritory(RandomUtil.generateStringField("try", 5).toUpperCase());
  }

  public Office generateOfficeWithNullField(List<String> nullFields) {
    // TODO use reflection to get name for fields
    return new Office();
  }

}

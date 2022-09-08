package com.klindziuk.sas.tdm.gen.util;

import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;

public final class RandomUtil {

  private RandomUtil() {
  }

  public static String email() {
    return RandomStringUtils.randomAlphanumeric(7).toLowerCase() + "@classicmodelcars.com";
  }

  public static String generateStringField(String prefix, int count) {
    return prefix + "-" + RandomStringUtils.randomAlphanumeric(count);
  }

  public static String checkNumber() {
    return "XYZ" + RandomStringUtils.randomNumeric(9);
  }

  public static <T> T getRandomElement(List<T> list) {
    int index = (int) (Math.random() * list.size());
    return list.get(index);
  }
}

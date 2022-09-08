package com.klindziuk.sas.tdm.gen.generator.model;

import com.klindziuk.sas.tdm.database.domain.ProductLineItem;
import com.klindziuk.sas.tdm.gen.util.RandomUtil;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductLineModelGenerator {

  public List<ProductLineItem> getProductLines(long size) {
    List<ProductLineItem> result = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      result.add(productLine());
    }
    return result;
  }

  public ProductLineItem productLine(){
    return new ProductLineItem()
        .setProductLine(RandomUtil.generateStringField("product-line", 12))
        .setImage(RandomUtil.generateStringField("image", 12))
        .setHtmlDescription(RandomUtil.generateStringField("html-description", 12))
        .setTextDescription(RandomUtil.generateStringField("text-description", 12));
  }

  public ProductLineItem generateProductLineWithNullField(List<String> nullFields){
    // TODO use reflection to get name for fields
    return new ProductLineItem();
  }

}

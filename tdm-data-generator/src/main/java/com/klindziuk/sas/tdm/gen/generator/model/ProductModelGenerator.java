package com.klindziuk.sas.tdm.gen.generator.model;

import com.klindziuk.sas.tdm.database.domain.Product;
import com.klindziuk.sas.tdm.database.domain.ProductLineItem;
import com.klindziuk.sas.tdm.gen.util.RandomUtil;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductModelGenerator {

  public List<Product> getProducts(long size, List<ProductLineItem> productLineItems) {
    List<Product> result = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      result.add(product(RandomUtil.getRandomElement(productLineItems)));
    }
    return result;
  }

  public Product product(ProductLineItem productLineItem){
    return new Product()
        .setProductCode(RandomUtil.generateStringField("code", 4))
        .setProductName(RandomUtil.generateStringField("name", 12))
        .setProductLineItem(productLineItem)
        .setProductScale(RandomUtil.generateStringField("scale", 4))
        .setProductVendor(RandomUtil.generateStringField("vendor", 12))
        .setProductDescription(RandomUtil.generateStringField("description", 12))
        .setQuantityInStock(111)
        .setBuyPrice(67.0)
        .setMsrp(87.2);

  }

  public Product generateProductWithNullField(List<String> nullFields){
    // TODO use reflection to get name for fields
    return new Product();
  }
}

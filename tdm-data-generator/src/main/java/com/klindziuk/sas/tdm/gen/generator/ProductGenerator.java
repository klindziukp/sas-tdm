package com.klindziuk.sas.tdm.gen.generator;

import com.klindziuk.sas.tdm.database.domain.Product;
import com.klindziuk.sas.tdm.database.domain.ProductLineItem;
import com.klindziuk.sas.tdm.database.repository.ProductRepository;
import com.klindziuk.sas.tdm.gen.config.generator.GeneratorConfig;
import com.klindziuk.sas.tdm.gen.generator.model.ProductModelGenerator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductGenerator {

  private final ProductRepository productRepository;
  private final ProductModelGenerator productModelGenerator;
  private final GeneratorConfig generatorConfig;

  @Autowired
  public ProductGenerator(
      ProductRepository productRepository,
      ProductModelGenerator productModelGenerator,
      GeneratorConfig generatorConfig) {
    this.productRepository = productRepository;
    this.productModelGenerator = productModelGenerator;
    this.generatorConfig = generatorConfig;
  }

  public List<Product> generateProductItems(List<ProductLineItem> productLineItems) {
    return productRepository.saveAllAndFlush(
        productModelGenerator.getProducts(itemsToGenerate(), productLineItems));
  }

  private long itemsToGenerate() {
    return generatorConfig.product().getSize() > 0 ? generatorConfig.product().getSize() : 1;
  }
}

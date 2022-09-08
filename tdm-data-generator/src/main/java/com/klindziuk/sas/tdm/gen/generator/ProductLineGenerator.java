package com.klindziuk.sas.tdm.gen.generator;

import com.klindziuk.sas.tdm.database.domain.ProductLineItem;
import com.klindziuk.sas.tdm.database.repository.ProductLineRepository;
import com.klindziuk.sas.tdm.gen.config.generator.GeneratorConfig;
import com.klindziuk.sas.tdm.gen.generator.model.ProductLineModelGenerator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductLineGenerator {

  private final ProductLineRepository productLineRepository;
  private final ProductLineModelGenerator productLineModelGenerator;
  private final GeneratorConfig generatorConfig;

  @Autowired
  public ProductLineGenerator(
      ProductLineRepository productLineRepository,
      ProductLineModelGenerator productLineModelGenerator,
      GeneratorConfig generatorConfig) {
    this.productLineRepository = productLineRepository;
    this.productLineModelGenerator = productLineModelGenerator;
    this.generatorConfig = generatorConfig;
  }

  public List<ProductLineItem> generateProductLineItems() {
    return productLineRepository.saveAllAndFlush(
        productLineModelGenerator.getProductLines(itemsToGenerate()));
  }

  private long itemsToGenerate() {
    return generatorConfig.productLine().getSize() > 0 ?
        generatorConfig.productLine().getSize() : 1;
  }
}

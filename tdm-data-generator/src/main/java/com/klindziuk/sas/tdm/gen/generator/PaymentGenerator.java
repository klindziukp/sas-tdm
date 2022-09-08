package com.klindziuk.sas.tdm.gen.generator;

import com.klindziuk.sas.tdm.database.domain.Customer;
import com.klindziuk.sas.tdm.database.domain.Payment;
import com.klindziuk.sas.tdm.database.repository.PaymentRepository;
import com.klindziuk.sas.tdm.gen.config.generator.GeneratorConfig;
import com.klindziuk.sas.tdm.gen.generator.model.PaymentModelGenerator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentGenerator {

  private final PaymentRepository productRepository;
  private final PaymentModelGenerator paymentModelGenerator;
  private final GeneratorConfig generatorConfig;

  @Autowired
  public PaymentGenerator(
      PaymentRepository productRepository,
      PaymentModelGenerator paymentModelGenerator,
      GeneratorConfig generatorConfig) {
    this.productRepository = productRepository;
    this.paymentModelGenerator = paymentModelGenerator;
    this.generatorConfig = generatorConfig;
  }

  public List<Payment> generatePaymentItems(List<Customer> customers) {
    return productRepository.saveAllAndFlush(
        paymentModelGenerator.generatePaymentModels(itemsToGenerate(), customers));
  }

  private long itemsToGenerate() {
    return generatorConfig.payment().getSize() > 0 ? generatorConfig.payment().getSize() : 1;
  }
}

package com.klindziuk.sas.tdm.gen.generator;

import com.klindziuk.sas.tdm.database.domain.Order;
import com.klindziuk.sas.tdm.database.domain.OrderDetail;
import com.klindziuk.sas.tdm.database.domain.Product;
import com.klindziuk.sas.tdm.database.repository.OrderDetailsRepository;
import com.klindziuk.sas.tdm.gen.config.generator.GeneratorConfig;
import com.klindziuk.sas.tdm.gen.generator.model.OrderDetailModelGenerator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailGenerator {

  private final OrderDetailsRepository orderDetailsRepository;
  private final OrderDetailModelGenerator orderDetailModelGenerator;
  private final GeneratorConfig generatorConfig;

  @Autowired
  public OrderDetailGenerator(
      OrderDetailsRepository orderDetailsRepository,
      OrderDetailModelGenerator orderDetailModelGenerator,
      GeneratorConfig generatorConfig) {
    this.orderDetailsRepository = orderDetailsRepository;
    this.orderDetailModelGenerator = orderDetailModelGenerator;
    this.generatorConfig = generatorConfig;
  }

  public List<OrderDetail> generateOrderDetails(List<Order> orders, List<Product> products) {
    return orderDetailsRepository.saveAllAndFlush(
        orderDetailModelGenerator.getOrderDetails(itemsToGenerate(), orders, products));
  }

  private long itemsToGenerate() {
    return generatorConfig.orderDetail().getSize() > 0 ? generatorConfig.orderDetail().getSize() : 1;
  }
}

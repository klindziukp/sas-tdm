package com.klindziuk.sas.tdm.gen.generator;

import com.klindziuk.sas.tdm.database.domain.Customer;
import com.klindziuk.sas.tdm.database.domain.Order;
import com.klindziuk.sas.tdm.database.repository.OrderRepository;
import com.klindziuk.sas.tdm.gen.config.generator.GeneratorConfig;
import com.klindziuk.sas.tdm.gen.generator.model.OrderModelGenerator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderGenerator {

  private final OrderRepository orderRepository;
  private final OrderModelGenerator orderModelGenerator;
  private final GeneratorConfig generatorConfig;

  @Autowired
  public OrderGenerator(
      OrderRepository orderRepository,
      OrderModelGenerator orderModelGenerator,
      GeneratorConfig generatorConfig) {
    this.orderRepository = orderRepository;
    this.orderModelGenerator = orderModelGenerator;
    this.generatorConfig = generatorConfig;
  }

  public List<Order> generateOrders(List<Customer> customers) {
    List<Order> existingCustomers = orderRepository.findAll();
    return orderRepository.saveAllAndFlush(
        orderModelGenerator.getOrders(itemsToGenerate(),existingCustomers, customers));
  }

  private long itemsToGenerate() {
    return generatorConfig.order().getSize() > 0 ? generatorConfig.order().getSize() : 1;
  }
}

package com.klindziuk.sas.tdm.layer.controller;

import com.klindziuk.sas.tdm.layer.repository.OrderRepository;
import com.klindziuk.sas.tdm.model.repository.Order;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

  private final OrderRepository orderRepository;

  @Autowired
  public OrderController(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @GetMapping(value = "api/v1/orders", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Order>> orders() {
    return ResponseEntity.ok(orderRepository.findAll());
  }
}

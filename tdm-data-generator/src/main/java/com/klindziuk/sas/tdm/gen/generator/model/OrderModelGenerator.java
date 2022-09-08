package com.klindziuk.sas.tdm.gen.generator.model;

import com.klindziuk.sas.tdm.database.domain.Customer;
import com.klindziuk.sas.tdm.database.domain.Order;
import com.klindziuk.sas.tdm.gen.util.RandomUtil;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderModelGenerator {

  public List<Order> getOrders(long size, List<Order> existingOrders, List<Customer> customers) {
    Collections.reverse(existingOrders);
    int customerStartId = existingOrders.isEmpty() ? 0 : existingOrders.get(0).getOrderNumber();
    int syntheticOrderId = customerStartId + 10;
    List<Order> result = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      syntheticOrderId++;
      result.add(order(syntheticOrderId, RandomUtil.getRandomElement(customers)));
    }
    return result;
  }

  public Order order(int orderId, Customer customer){
    return new Order()
        .setOrderNumber(orderId)
        .setOrderDate(new Date(System.currentTimeMillis()))
        .setRequiredDate(new Date(System.currentTimeMillis()))
        .setShippedDate(new Date(System.currentTimeMillis()))
        .setStatus("SHIPPED")
        .setComments("No comment for now!")
        .setCustomerNumber(customer.getCustomerNumber());
  }

  public Order generateOrdersWithNullField(List<String> nullFields) {
    // TODO use reflection to get name for fields
    return new Order();
  }

}

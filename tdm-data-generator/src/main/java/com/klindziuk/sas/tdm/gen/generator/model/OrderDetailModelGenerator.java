package com.klindziuk.sas.tdm.gen.generator.model;

import com.klindziuk.sas.tdm.database.domain.Order;
import com.klindziuk.sas.tdm.database.domain.OrderDetail;
import com.klindziuk.sas.tdm.database.domain.Product;
import com.klindziuk.sas.tdm.gen.util.RandomUtil;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailModelGenerator {

  public List<OrderDetail> getOrderDetails(long size, List<Order> orders, List<Product> products) {
    List<OrderDetail> result = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      result.add(
          orderDetail(RandomUtil.getRandomElement(orders), RandomUtil.getRandomElement(products)));
    }
    return result;
  }

  public OrderDetail orderDetail(Order order, Product product) {
    return new OrderDetail()
        .setOrder(order)
        .setOrderNumber(order.getOrderNumber())
        .setProduct(product)
        .setProductCode(product.getProductCode())
        .setQuantityOrdered(3)
        .setPriceEach(29.00)
        .setOrderLineNumber(3);
  }

  public Order generateOrdersWithNullField(List<String> nullFields) {
    // TODO use reflection to get name for fields
    return new Order();
  }

}

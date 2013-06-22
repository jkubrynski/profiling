package com.kubrynski.profiling.service;

import com.kubrynski.profiling.model.Order;
import com.kubrynski.profiling.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author jkubrynski@gmail.com
 * @since 2013-06-22
 */
@Component
public class OrderService {

  private Map<String, Order> ordersCache = Collections.synchronizedMap(new WeakHashMap<String, Order>());

  @Autowired
  private OrderRepository orderRepository;

  public Order getOrder(String orderId) {
    if (ordersCache.containsKey(orderId)) {
      return ordersCache.get(orderId);
    } else {
      Order retrievedOrder = orderRepository.getOrderById(orderId);
      ordersCache.put(orderId, retrievedOrder);
      return retrievedOrder;
    }
  }

  public void saveOrder(Order order) {
    orderRepository.saveOrder(order);
  }
}

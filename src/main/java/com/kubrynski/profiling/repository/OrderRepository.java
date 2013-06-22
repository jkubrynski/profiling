package com.kubrynski.profiling.repository;

import com.kubrynski.profiling.model.Order;
import com.kubrynski.profiling.model.OrderStatus;
import com.kubrynski.profiling.util.RandomProvider;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

/**
 * @author jkubrynski@gmail.com
 * @since 2013-06-22
 */
@Component
public class OrderRepository {

  public Order getOrderById(String orderId) {
    Order.OrderBuilder orderBuilder = new Order.OrderBuilder();
    return orderBuilder
        .withId(orderId)
        .withDescription(RandomProvider.getRandomString())
        .withPrice(RandomProvider.getRandom().nextInt())
        .withCreateDate(new DateTime())
        .withValidDate(new DateTime().plusMonths(1))
        .withStatus(OrderStatus.NEW)
        .createOrder();
  }

  public void saveOrder(Order order) {

  }
}

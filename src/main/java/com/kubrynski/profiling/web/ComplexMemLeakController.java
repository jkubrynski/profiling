package com.kubrynski.profiling.web;

import com.kubrynski.profiling.model.Order;
import com.kubrynski.profiling.model.OrderStatus;
import com.kubrynski.profiling.service.OrderService;
import com.kubrynski.profiling.util.RandomProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jkubrynski@gmail.com
 * @since 2013-06-22
 */
@Controller
public class ComplexMemLeakController {

  private static final Logger LOG = LoggerFactory.getLogger(ComplexMemLeakController.class);

  private static final int N_THREADS = 5;

  @Autowired
  private OrderService orderService;

  @RequestMapping("/complex_mem_leak")
  public @ResponseBody String home() {

    ExecutorService executorService = Executors.newFixedThreadPool(N_THREADS);

    final CountDownLatch finish = new CountDownLatch(N_THREADS);

    final Runnable task = new Runnable() {
      @Override public void run() {
        for (int i = 0; i < 2_000; i++) {
          Order order = orderService.getOrder(RandomProvider.getRandomString());
          order.setStatus(OrderStatus.CONFIRMED);
          orderService.saveOrder(order);
        }
        finish.countDown();
      }
    };

    for (int i = 0; i < N_THREADS; i++) {
      executorService.submit(task);
    }

    try {
      finish.await();
    } catch (InterruptedException e) {
      LOG.error("CountDownLatch interrupted", e);
    }

    executorService.shutdown();

    return "One step closer to memory leak";
  }

}

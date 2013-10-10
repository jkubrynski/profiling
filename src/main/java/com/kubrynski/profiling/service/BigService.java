package com.kubrynski.profiling.service;

import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author jkubrynski@gmail.com
 * @since 2013-10-08
 */
@Service
public class BigService {

  public boolean checkCompany(String name) {
    Random random = new Random(name.hashCode());
    boolean status = false;
    for (int i = 0; i < 10_000; i++) {
      for (int j = 0; j < 2_000; j++) {
        status = random.nextBoolean();
      }
    }
    return status;
  }
}

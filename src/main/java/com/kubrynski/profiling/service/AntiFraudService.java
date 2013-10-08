package com.kubrynski.profiling.service;

import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author jkubrynski@gmail.com
 * @since 2013-10-08
 */
@Service
public class AntiFraudService {

  public boolean verify(String websiteUrl) {
    Random random = new Random(websiteUrl.hashCode());
    boolean status = false;
    for (int i = 0; i < 5_000_000; i++) {
      status = random.nextBoolean();
    }
    return status;
  }
}

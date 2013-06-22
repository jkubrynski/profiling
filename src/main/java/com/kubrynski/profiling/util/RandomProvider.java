package com.kubrynski.profiling.util;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * @author jkubrynski@gmail.com
 * @since 2013-06-22
 */
public class RandomProvider {

  private static SecureRandom random = new SecureRandom();

  public static SecureRandom getRandom() {
    return random;
  }

  public static String getRandomString() {
    return new BigInteger(128, random).toString(32);
  }
}

package com.kubrynski.profiling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

/**
 * @author jkubrynski@gmail.com
 * @since 2013-10-06
 */
@Service
public class ShopService {

  @Autowired
  private DataSource dataSource;

  public int countShops() {

    int size = 0;

    Connection connection = null;
    try {
      connection = dataSource.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement("select count(*) from shop;");

      ResultSet resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        size = resultSet.getInt(1);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {

      if (new Random().nextBoolean()) {
        if (connection != null) {
          try {
            connection.close();
          } catch (SQLException e) {
            e.printStackTrace();
          }
        }
      }
    }


    return size;
  }
}

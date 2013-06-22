package com.kubrynski.profiling.model;

import com.google.common.base.Objects;
import org.joda.time.DateTime;


/**
 * @author jkubrynski@gmail.com
 * @since 2013-06-22
 */
public class Order {

  private String id;
  private String description;
  private Integer price;
  private DateTime createDate;
  private DateTime validDate;
  private OrderStatus status;


  private Order(String id, String description, Integer price, DateTime createDate, DateTime validDate, OrderStatus status) {
    this.id = id;
    this.description = description;
    this.price = price;
    this.createDate = createDate;
    this.validDate = validDate;
    this.status = status;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public DateTime getCreateDate() {
    return createDate;
  }

  public void setCreateDate(DateTime createDate) {
    this.createDate = createDate;
  }

  public DateTime getValidDate() {
    return validDate;
  }

  public void setValidDate(DateTime validDate) {
    this.validDate = validDate;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public static class OrderBuilder {

    private String id;
    private String description;
    private Integer price;
    private DateTime createDate;
    private DateTime validDate;
    private OrderStatus status;

    public OrderBuilder withId(String id) {
      this.id = id;
      return this;
    }

    public OrderBuilder withDescription(String description) {
      this.description = description;
      return this;
    }

    public OrderBuilder withPrice(Integer price) {
      this.price = price;
      return this;
    }

    public OrderBuilder withCreateDate(DateTime createDate) {
      this.createDate = createDate;
      return this;
    }

    public OrderBuilder withValidDate(DateTime validDate) {
      this.validDate = validDate;
      return this;
    }

    public OrderBuilder withStatus(OrderStatus status) {
      this.status = status;
      return this;
    }

    public Order createOrder() {
      return new Order(id, description, price, createDate, validDate, status);
    }
  }

  @Override public int hashCode() {
    return Objects.hashCode(getId());
  }

  @Override public boolean equals(Object other) {
    if (other == this) return true;
    return other instanceof Order && Objects.equal(getId(), ((Order) other).getId());
  }
}

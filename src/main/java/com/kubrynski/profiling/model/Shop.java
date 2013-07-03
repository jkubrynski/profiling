package com.kubrynski.profiling.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

/**
 * @author jkubrynski@gmail.com
 * @since 2013-07-03
 */
@Entity
public class Shop extends AbstractPersistable<Long> {

  public Shop() {
  }

  public Shop(String name, String websiteUrl) {
    this.name = name;
    this.websiteUrl = websiteUrl;
  }

  private String name;
  private String websiteUrl;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getWebsiteUrl() {
    return websiteUrl;
  }

  public void setWebsiteUrl(String websiteUrl) {
    this.websiteUrl = websiteUrl;
  }
}

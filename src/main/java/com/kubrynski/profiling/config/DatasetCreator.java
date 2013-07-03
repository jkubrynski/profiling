package com.kubrynski.profiling.config;

import com.kubrynski.profiling.model.Shop;
import com.kubrynski.profiling.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author jkubrynski@gmail.com
 * @since 2013-07-03
 */
@Component
public class DatasetCreator {

  @Autowired
  private ShopRepository shopRepository;

  @PostConstruct
  public void initDataset() {
    shopRepository.save(new Shop("Castorama", "www.castorama.pl"));
    shopRepository.save(new Shop("Leroy Merlin", "www.leroymerlin.pl"));
    shopRepository.save(new Shop("Empik", "www.empik.com"));
  }

}

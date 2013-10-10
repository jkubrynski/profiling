package com.kubrynski.profiling.config;

import com.kubrynski.profiling.model.Shop;
import com.kubrynski.profiling.repository.ShopRepository;
import eu.codearte.fairyland.Hook;
import eu.codearte.fairyland.producer.Company;
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
    Hook hook = Hook.create();
    for (int i = 0; i < 100; i++) {
      Company company = hook.company();
      shopRepository.save(new Shop(company.name(), company.url()));
    }
  }

}

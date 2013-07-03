package com.kubrynski.profiling.web;

import com.kubrynski.profiling.repository.ShopRepository;
import com.kubrynski.profiling.util.RandomProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jkubrynski@gmail.com
 * @since 2013-06-22
 */
@Controller
public class ShopController {

  @Autowired
  private ShopRepository shopRepository;

  @RequestMapping("/shops")
  public String all(Model model) {
    model.addAttribute("shops", shopRepository.findAll());
    return "shopList";
  }

}

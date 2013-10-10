package com.kubrynski.profiling.web;

import com.kubrynski.profiling.repository.ShopRepository;
import com.kubrynski.profiling.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jkubrynski@gmail.com
 * @since 2013-06-22
 */
@Controller
public class ShopController {

  @Autowired
  private ShopRepository shopRepository;

  @Autowired
  private ShopService shopService;

  @RequestMapping("/shops")
  public String all(Model model) {
    model.addAttribute("shops", shopRepository.findAll());
    return "shopList";
  }

  @RequestMapping("/shops/count")
  public String shopCount(Model model) {
    model.addAttribute("shopsCount", shopService.countShops());
    return "shopsCount";
  }

  @RequestMapping("/shops/verify/{shopId}")
  public String verify(@PathVariable int shopId, Model model) {
    model.addAttribute("verificationStatus", shopService.verifyShop(shopId));
    return "shopVerificationResult";
  }
}

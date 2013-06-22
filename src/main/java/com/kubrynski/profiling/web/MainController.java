package com.kubrynski.profiling.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jkubrynski@gmail.com
 * @since 2013-06-22
 */
@Controller
public class MainController {
  @RequestMapping("/")
  public String home() {
    return "home";
  }

  @RequestMapping("/*")
  public @ResponseBody String all() {
    return "I'm not sure we've such page";
  }
}

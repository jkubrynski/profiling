package com.kubrynski.profiling.web;

import com.google.common.collect.Lists;
import com.kubrynski.profiling.util.RandomProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author jkubrynski@gmail.com
 * @since 2013-06-22
 */
@Controller
public class SimpleMemLeakController {

  private List<Integer> integers = Lists.newArrayList();

  @RequestMapping("/simple_mem_leak")
  public @ResponseBody String all() {
    for (int i = 0; i < 1_000_000; i++) {
      integers.add(RandomProvider.getRandom().nextInt());
    }
    return "One next step to simple memory leak";
  }

}

package com.kubrynski.profiling.web;

import com.warecki.gc.GcTesterOptions;
import com.warecki.gc.runner.GcProcessRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class GcTesterController {

    @RequestMapping(value = "/gc", method = RequestMethod.GET)
    public String gc() {
        //do nothing
        return "gc";
    }

    @RequestMapping(value = "/gc/create", method = RequestMethod.POST)
    public String create(@RequestParam(GcTesterOptions.THREAD_NUM) String threadNum,
                         @RequestParam(GcTesterOptions.CLEAR_TIME) String clearTime,
                         @RequestParam(GcTesterOptions.ARRAY_SIZE) String arraySize,
                         @RequestParam(GcTesterOptions.INIT_DATA) String initData,
                         @RequestParam("jvmargs") String jvmArgs) {

        Map<String, String> progArgs = new HashMap<>(4);
        progArgs.put(GcTesterOptions.THREAD_NUM, threadNum);
        progArgs.put(GcTesterOptions.CLEAR_TIME, clearTime);
        progArgs.put(GcTesterOptions.ARRAY_SIZE, arraySize);
        progArgs.put(GcTesterOptions.INIT_DATA, initData);

        GcProcessRunner.runNewProcess(progArgs, jvmArgs);
        return "gcprocess";
    }

    @RequestMapping(value = "/gc/kill", method = RequestMethod.GET)
    public String kill() {
        GcProcessRunner.stopCurrentProcess();
        return "gc";
    }

}

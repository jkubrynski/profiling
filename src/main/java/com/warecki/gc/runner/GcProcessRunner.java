package com.warecki.gc.runner;


import com.warecki.gc.GcTesterOptions;

import java.io.*;
import java.util.Map;

public final class GcProcessRunner {

    //... to change
    public static final String PROG_PATH = "java %s -cp ./target/profiling-1.0.0-SNAPSHOT/WEB-INF/lib/*:./target/classes com.warecki.gc.GcTester";

    private static Process runningProcess;

    private GcProcessRunner() {}

    public static void runNewProcess(Map<String, String> progArgs, String jvmArgs) {

        StringBuilder exec = new StringBuilder();
        exec.append(String.format(PROG_PATH, jvmArgs));

        for(String arg : progArgs.keySet()) {
            exec.append(" -" + arg);
            exec.append(" " + progArgs.get(arg));
        }

        try {
            runningProcess = Runtime.getRuntime().exec(exec.toString());
            System.out.println("Executed: " + exec.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void stopCurrentProcess() {
        if(runningProcess != null) {
            runningProcess.destroy();
        }
    }

}

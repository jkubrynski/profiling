package com.warecki.gc;

import org.apache.commons.cli.*;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GcTester {

    private final int threadNum;
    private final int arraySize;
    private final int clearTime;
    private final ExecutorService service;

    private static ConcurrentLinkedQueue<Object> data = new ConcurrentLinkedQueue<>();
    private static ConcurrentLinkedQueue<Object> constData = new ConcurrentLinkedQueue<>();
    private static volatile boolean running = true;

    public GcTester(int threadNum, int arraySize, int clearTime) {
        this.threadNum = threadNum;
        this.arraySize = arraySize;
        this.clearTime = clearTime;
        service = Executors.newFixedThreadPool(threadNum);
    }

    private void startFilling() {
        while (running) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    data.add(new long[arraySize]);
                }
            });

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
                System.exit(-1);
            }
        }
    }

    private void startTester() {
        Executors.newFixedThreadPool(1).submit(new Runnable() {
            @Override
            public void run() {
                startFilling();
            }
        });

        while (running) {
            try {
                Thread.sleep(clearTime);
            } catch (InterruptedException e) {}

            data.clear();
        }
    }

    public void putConstData(int size) {
        constData.add(new long[size]);
    }

    public static void main(String[] args) {

        System.out.println("Running");
        // create the parser
        final CommandLineParser parser = new BasicParser();

        try {
            // parse the command line arguments
            final CommandLine line = parser.parse(getOptions(), args);
            final int threadNum = Integer.valueOf(line.getOptionValue(GcTesterOptions.THREAD_NUM));
            final int arraySize = Integer.valueOf(line.getOptionValue(GcTesterOptions.ARRAY_SIZE));
            final int clearTime = Integer.valueOf(line.getOptionValue(GcTesterOptions.CLEAR_TIME));
            final int initData = Integer.valueOf(line.getOptionValue(GcTesterOptions.INIT_DATA));

            final GcTester gcTester = new GcTester(threadNum, arraySize, clearTime);
            gcTester.putConstData(initData);

            gcTester.startTester();

        } catch( ParseException exp ) {
            System.err.println("Parsing failed.  Reason: " + exp.getMessage());
            System.exit(-1);
        }


    }

    private static Options getOptions() {
        Options options = new Options();
        options.addOption(GcTesterOptions.THREAD_NUM, true, "number of threads");
        options.addOption(GcTesterOptions.ARRAY_SIZE, true, "size of array of longs");
        options.addOption(GcTesterOptions.CLEAR_TIME, true, "clear time");
        options.addOption(GcTesterOptions.INIT_DATA, true, "size of array of longs to put at program start");

        return options;
    }

}

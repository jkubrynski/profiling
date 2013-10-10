package com.warecki.jit;


/**
 * -XX:+UnlockDiagnosticVMOptions
 * -XX:CompileThreshold=
 * -XX:+PrintCompilation
 * -XX:+PrintAssembly
 */
public class Compilation {

    int a, b;
    volatile int v, u;

    void memBarTest() {
        int i, j;

        i = a;
        j = b;
        i = v;
        //LoadLoad
        j = u;
        //LoadStore
        a = i;
        b = j;
        //StoreStore
        v = i;
        //StoreStore
        u = j;
        //StoreLoad
        i = u;
        //LoadLoad
        //LoadStore
        j = b;
        a = i;
    }

    public static void main(final String[] args) {
        Compilation main = new Compilation();
        for (int i = 0; i < 9999; i++) {
            main.memBarTest();
        }
    }

    public static void naiveNanoBenchmark() {
        Compilation main = new Compilation();
        long before = System.nanoTime();
        main.memBarTest();
        long after = System.nanoTime();
        System.out.println(after - before);
    }

    public static void betterNanoBenchmark() {
        Compilation main = new Compilation();
        for (int i = 0; i < 10000; i++) {
            main.memBarTest();
        }

        long before = System.nanoTime();
        main.memBarTest();
        long after = System.nanoTime();
        System.out.println(after - before);
    }

}
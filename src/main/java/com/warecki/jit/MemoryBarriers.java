package com.warecki.jit;

public class MemoryBarriers {

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
        MemoryBarriers main = new MemoryBarriers();
        for (int i = 0; i < 11000; i++) {
            main.memBarTest();
        }
    }

}
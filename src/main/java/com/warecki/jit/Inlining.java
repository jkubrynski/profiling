package com.warecki.jit;

/**
 * -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining
 * -XX:MaxInlineSize=
 * -XX:MinInliningThreshold=
 */
public class Inlining {

    public static void main(String[] args) {
        Inlining inlining = new Inlining();

        inlining.cold(5, 9);

        for (int i = 0; i < 15000; i++) {
            inlining.hot(3, 4);
        }

        for (int i = 0; i < 15000; i++) {
            inlining.hotTooBig(3, 4);
        }

        inlining.coldTooBig(9, 34);
    }

    public int cold(int a, int b) {
        return a * b;
    }

    public int hot(int a, int b) {
        return a + b;
    }

    public int hotTooBig(int a, int b) {
        int tmp = 0;
        tmp = a + b;
        tmp = tmp + 1;
        tmp = tmp + a;
        tmp = tmp + b + 1;
        a = a + 3;
        b = a + 9;
        tmp = tmp + b + a;
        tmp = tmp + 3;
        tmp = b - a - tmp;
        tmp = (int) (tmp * 1.76 - a);
        b = 19;
        a = 33;
        tmp = a + b + tmp;
        b = (int) (3.45 * 4);
        tmp = b * tmp - a;
        tmp = (int) (tmp * 0.2);
        tmp = tmp + b + a;
        tmp = tmp + 3;
        tmp = b - a - tmp;
        tmp = (int) (tmp * 1.76 - a);
        b = 19;
        a = 33;
        tmp = a + b + tmp;
        b = (int) (3.45 * 4);
        tmp = b * tmp - a;
        tmp = (int) (tmp * 0.2);
        tmp = tmp + 1;
        tmp = tmp + a;
        tmp = tmp + b + 1;
        a = a + 3;
        b = a + 9;
        tmp = tmp + b + a;
        tmp = tmp + 3;
        tmp = b - a - tmp;
        tmp = (int) (tmp * 1.76 - a);
        b = 19;
        a = 33;
        tmp = a + b + tmp;
        b = (int) (3.45 * 4);
        tmp = b * tmp - a;
        tmp = (int) (tmp * 0.2);
        tmp = tmp + b + a;
        tmp = tmp + 3;
        tmp = b - a - tmp;
        tmp = (int) (tmp * 1.76 - a);
        b = 19;
        a = 33;
        tmp = a + b + tmp;
        b = (int) (3.45 * 4);
        tmp = b * tmp - a;
        tmp = (int) (tmp * 0.2);
        tmp = tmp + 1;
        tmp = tmp + a;
        tmp = tmp + b + 1;
        a = a + 3;
        b = a + 9;
        tmp = tmp + b + a;
        tmp = tmp + 3;
        tmp = b - a - tmp;
        tmp = (int) (tmp * 1.76 - a);
        b = 19;
        a = 33;
        tmp = a + b + tmp;
        b = (int) (3.45 * 4);
        tmp = b * tmp - a;
        tmp = (int) (tmp * 0.2);
        tmp = tmp + b + a;
        tmp = tmp + 3;
        tmp = b - a - tmp;
        tmp = (int) (tmp * 1.76 - a);
        b = 19;
        a = 33;
        tmp = a + b + tmp;
        b = (int) (3.45 * 4);
        tmp = b * tmp - a;
        tmp = (int) (tmp * 0.2);

        return tmp;
    }

    public int coldTooBig(int a, int b) {
        int tmp = 0;
        tmp = a + b;
        tmp = tmp + 1;
        tmp = tmp + a;
        tmp = tmp + b + 1;
        a = a + 3;
        b = a + 9;
        tmp = tmp + b + a;
        tmp = tmp + 3;
        tmp = b - a - tmp;
        tmp = (int) (tmp * 1.76 - a);
        b = 19;
        a = 33;
        tmp = a + b + tmp;
        b = (int) (3.45 * 4);
        tmp = b * tmp - a;
        tmp = (int) (tmp * 0.2);
        tmp = tmp + b + a;
        tmp = tmp + 3;
        tmp = b - a - tmp;
        tmp = (int) (tmp * 1.76 - a);
        b = 19;
        a = 33;
        tmp = a + b + tmp;
        b = (int) (3.45 * 4);
        tmp = b * tmp - a;
        tmp = (int) (tmp * 0.2);
        tmp = tmp + 1;
        tmp = tmp + a;
        tmp = tmp + b + 1;
        a = a + 3;
        b = a + 9;
        tmp = tmp + b + a;
        tmp = tmp + 3;
        tmp = b - a - tmp;
        tmp = (int) (tmp * 1.76 - a);
        b = 19;
        a = 33;
        tmp = a + b + tmp;
        b = (int) (3.45 * 4);
        tmp = b * tmp - a;
        tmp = (int) (tmp * 0.2);
        tmp = tmp + b + a;
        tmp = tmp + 3;
        tmp = b - a - tmp;
        tmp = (int) (tmp * 1.76 - a);
        b = 19;
        a = 33;
        tmp = a + b + tmp;
        b = (int) (3.45 * 4);
        tmp = b * tmp - a;
        tmp = (int) (tmp * 0.2);
        tmp = tmp + 1;
        tmp = tmp + a;
        tmp = tmp + b + 1;
        a = a + 3;
        b = a + 9;
        tmp = tmp + b + a;
        tmp = tmp + 3;
        tmp = b - a - tmp;
        tmp = (int) (tmp * 1.76 - a);
        b = 19;
        a = 33;
        tmp = a + b + tmp;
        b = (int) (3.45 * 4);
        tmp = b * tmp - a;
        tmp = (int) (tmp * 0.2);
        tmp = tmp + b + a;
        tmp = tmp + 3;
        tmp = b - a - tmp;
        tmp = (int) (tmp * 1.76 - a);
        b = 19;
        a = 33;
        tmp = a + b + tmp;
        b = (int) (3.45 * 4);
        tmp = b * tmp - a;
        tmp = (int) (tmp * 0.2);

        return tmp;

    }

}

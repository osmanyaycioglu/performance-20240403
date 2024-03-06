package org.training.performance.benchmark;

import java.util.LinkedList;
import java.util.List;

public class StringBenchTest2 {
    public static void main(String[] args) throws Exception {
        int a = 100;
        String str = "another";
        for (int i = 0; i < 20_000; i++) {
            String stringLoc = "Test " + a + " " +str;

        }
        for (int i = 0; i < 20_000; i++) {
            String stringLoc = String.format("Test %d %s", a,str);
        }
        Thread.sleep(1_000);
        System.gc();
        Thread.sleep(1_000);

        long delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            String stringLoc = "Test " + a + " " +str;
        }
        System.out.println("concat delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            String stringLoc = String.format("Test %d %s", a,str);
        }
        System.out.println("format delta : " + (System.currentTimeMillis() - delta));

    }
}

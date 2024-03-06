package org.training.performance.benchmark;

import java.util.logging.Level;
import java.util.logging.Logger;

public class StringBenchTest {
    static Logger logger = Logger.getLogger(SetBenchTest.class.getName());

    public static void main(String[] args) {
        String data = "test";
        int a = 100;

        String total = data + " " + a + " deneme";
        total += " another str";

        String start = "str";
        for (int i = 0; i < 100 ; i++) {
            start += " " +i;
        }
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(data + " " + a + " deneme");
        }

        // logger.fine("{} {} deneme", data, a );

        StringBuilder builderLoc = new StringBuilder();
        builderLoc.append("str");
        for (int i = 0; i < 100 ; i++) {
            builderLoc.append(" ").append(i);
            // builderLoc.append(" " + i);
        }
        System.out.println(builderLoc.toString());

    }
}

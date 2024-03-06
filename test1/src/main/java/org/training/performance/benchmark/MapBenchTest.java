package org.training.performance.benchmark;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapBenchTest {

    private Map<String,String> stringsLoc = new ConcurrentHashMap<>(1_200_000,0.9f,1_000);

    public static void main(String[] args) throws Exception {
        Map<String,String> stringsLoc = new HashMap<>(1_000_000);
        for (int i = 0; i < 20_000; i++) {
            String stringLoc = "stringsLoc" + i;
            stringsLoc.put(stringLoc,stringLoc);
        }
        for (int i = 0; i < 20_000; i++) {
            stringsLoc.remove("stringsLoc" + i);
        }
        Thread.sleep(1_000);
        stringsLoc.clear();
        System.gc();
        Thread.sleep(1_000);

        long delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            String stringLoc = "stringsLoc" + i;
            stringsLoc.put(stringLoc,stringLoc);
        }
        System.out.println("add delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (Map.Entry<String, String> stringLoc : stringsLoc.entrySet()) {

        }
        System.out.println("travers delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            stringsLoc.containsKey("stringsLoc" + i);
        }
        System.out.println("contains delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            stringsLoc.remove("stringsLoc" + i);
        }
        System.out.println("remove delta : " + (System.currentTimeMillis() - delta));


    }

}

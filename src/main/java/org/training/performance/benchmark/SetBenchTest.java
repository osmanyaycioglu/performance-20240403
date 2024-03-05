package org.training.performance.benchmark;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class SetBenchTest {

    private Set<String> tjreadSafeStringsLoc = ConcurrentHashMap.newKeySet();


    public static void main(String[] args) throws Exception {
        Set<String> stringsLoc = new HashSet<>(1_000_000);
        for (int i = 0; i < 20_000; i++) {
            stringsLoc.add("stringsLoc" + i);
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
            stringsLoc.add("stringsLoc" + i);
        }
        System.out.println("add delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (String stringLoc : stringsLoc) {

        }
        System.out.println("travers delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            stringsLoc.contains("stringsLoc" + i);
        }
        System.out.println("contains delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            stringsLoc.remove("stringsLoc" + i);
        }
        System.out.println("remove delta : " + (System.currentTimeMillis() - delta));

        // kullan
        stringsLoc.removeAll(Arrays.asList("stringsLoc1","stringsLoc1"));
        stringsLoc.retainAll(Arrays.asList("stringsLoc3","stringsLoc4"));
        stringsLoc.containsAll(Arrays.asList("stringsLoc3","stringsLoc4"));
        stringsLoc.addAll(Arrays.asList("stringsLoc3","stringsLoc4"));

    }

}

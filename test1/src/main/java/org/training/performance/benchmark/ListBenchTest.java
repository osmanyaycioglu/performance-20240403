package org.training.performance.benchmark;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListBenchTest {

    private static List<String> list = new ArrayList<>();
    private static List<String> list2 = new Vector<>();
    private static List<String> list3 = Collections.synchronizedList(new ArrayList<>());

    private static List<String> list4 = new CopyOnWriteArrayList<>();


    private void method() {
        List<String> list = new ArrayList<>();

    }

    public static void main(String[] args) throws Exception {
        // List<String> stringsLoc = new ArrayList<>(1_000_000);
        List<String> stringsLoc = new LinkedList<>();
        for (int i = 0; i < 20_000; i++) {
            stringsLoc.add("stringsLoc" + i);
        }
        for (int i = 0; i < 20_000; i++) {
            stringsLoc.remove(0);
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
        for (int i = 0; i < 1_000; i++) {
            stringsLoc.get(i);
        }
        System.out.println("get delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (String stringLoc : stringsLoc) {

        }
        System.out.println("travers delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (int i = 100_000; i < 101_000; i++) {
            stringsLoc.contains("stringsLoc" + i);
        }
        System.out.println("contains delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            stringsLoc.remove(0);
        }
        System.out.println("remove delta : " + (System.currentTimeMillis() - delta));

        delta = System.currentTimeMillis();
        for (int i = 0; i < 1_000; i++) {
            stringsLoc.remove("stringsLoc" + i);
        }
        System.out.println("remove2 delta : " + (System.currentTimeMillis() - delta));



        // kullanma
        stringsLoc.removeAll(Arrays.asList("stringsLoc1","stringsLoc1"));
        stringsLoc.retainAll(Arrays.asList("stringsLoc3","stringsLoc4"));
        stringsLoc.containsAll(Arrays.asList("stringsLoc3","stringsLoc4"));
        // kullan
        stringsLoc.addAll(Arrays.asList("stringsLoc3","stringsLoc4"));

    }

}

package org.training.performance.test1;

import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

public class EmployeeRun {
    private static HashMap<String,Employee> employeeHashMap = new HashMap<>();
    public static void main(String[] args) {

        try (Scanner scannerLoc = new Scanner(System.in)) {
            System.out.println("Kac tane request yaratayım : ");
            int iLoc = scannerLoc.nextInt();
            for (int i = 0; i < iLoc; i++) {
                Employee employeeLoc = new Employee();
                employeeLoc.setName("test" + i);
                employeeLoc.setSurname("surname" + i);
                employeeLoc.setAge(i);
                employeeLoc.setHeight(i);
                employeeHashMap.put(employeeLoc.getName(), employeeLoc);
            }
            System.out.println(iLoc + " request yaratıldı.");
            EmployeeRun employeeRunLoc = new EmployeeRun();
            for (int i = 0; i < 5; i++) {
                MyRunnerThread myRunnerThreadLoc = new MyRunnerThread(employeeRunLoc);
                myRunnerThreadLoc.setName("Runner-" + i);
                myRunnerThreadLoc.start();
            }
        }
        try {
            Thread.sleep(10_000_000_000L);
        } catch (InterruptedException eParam) {
            throw new RuntimeException(eParam);
        }
    }

    public static class MyRunnerThread extends Thread {
        private EmployeeRun employeeRun;

        public MyRunnerThread(final EmployeeRun employeeRunParam) {
            employeeRun = employeeRunParam;
        }

        @Override
        public void run() {
            while(true) {
                employeeRun.firstMethod();
            }
        }
    }


    public void firstMethod(){
        String stringLoc = UUID.randomUUID()
                               .toString();
        secondMethod();
    }

    public void secondMethod(){
        String stringLoc = UUID.randomUUID()
                               .toString();
//        try {
//            Thread.sleep(10);
//        } catch (Exception exp) {
//        }
        thirdMethod();

    }
    public void thirdMethod(){
        for (int i = 0; i < 100; i++) {
            String stringLoc = UUID.randomUUID()
                                   .toString();
        }
        forthMethod();
    }
    public void forthMethod(){
        for (int i = 0; i < 10; i++) {
            String stringLoc = UUID.randomUUID()
                                   .toString();
        }
        fifthMethod();
    }
    public void fifthMethod(){
        String stringLoc = UUID.randomUUID()
                               .toString();

    }

}

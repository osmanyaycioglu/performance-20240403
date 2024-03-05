package org.training.performance.test1;

import java.util.HashMap;
import java.util.Scanner;

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
        }
        try {
            Thread.sleep(10_000_000_000L);
        } catch (InterruptedException eParam) {
            throw new RuntimeException(eParam);
        }

    }
}

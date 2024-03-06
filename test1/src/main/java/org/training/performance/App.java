package org.training.performance;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Map<String,Customer> customerMap = new HashMap<>();

    public static void main( String[] args )
    {
        long counter = 0;
        while(true) {
            App appLoc  =new App();
            Customer customerLoc = new Customer();
            customerLoc.setName("osman" + counter);
            customerLoc.setSurname("yaycıoğlu" + counter);
            customerLoc.setAge(54);
            customerLoc.setHeight(200);

            Customer customerLoc2 = customerLoc;
            appLoc.method();
            counter++;

            if (counter % 100 == 0){
                customerMap.put(customerLoc.getName(),customerLoc);
            }
            if (customerMap.size() > 2_000_000) {
                Set<String> stringsLoc = customerMap.keySet();
                int exitCount = 0;
                Set<String> mySet = new HashSet<>(stringsLoc);
                for (String stringLoc : mySet) {
                    exitCount++;
                    if (exitCount > 500_000){
                        break;
                    }
                    customerMap.remove(stringLoc);
                }
            }
            if (counter % 10_000 == 0){
                System.out.println("Sleeping : " + counter);
                try {
                    Thread.sleep(1);
                } catch (Exception exp) {
                }
            }
        }
    }

    public void method(){
        Customer customerLoc = new Customer();
        customerLoc.setName("ali");
        customerLoc.setSurname("veli");
        customerLoc.setAge(30);
        customerLoc.setHeight(170);

        anotherMethod(customerLoc);

    }

    public void anotherMethod(Customer cust){
        cust.setName("test");
    }

}

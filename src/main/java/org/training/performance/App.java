package org.training.performance;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        App appLoc  =new App();
        Customer customerLoc = new Customer();
        customerLoc.setName("osman");
        customerLoc.setSurname("yaycıoğlu");
        customerLoc.setAge(54);
        customerLoc.setHeight(200);

        Customer customerLoc2 = customerLoc;
        appLoc.method();
        customerLoc2 = null;
        customerLoc = null;
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

package org.training.performance.multithread;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class MyThreadSafe {

    private long       counter       = 0;
    private AtomicLong atomicCounter = new AtomicLong();
    private StringBuffer stringBuffer = new StringBuffer();
    // private SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
    private DateTimeFormatter c = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
    private long data;
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    public void operation() {
        atomicCounter.incrementAndGet();
    }

    public void operation2() {
        System.out.println("deneme");
        stringBuffer.append("xyz");
        System.out.println(c.format(LocalDateTime.now()));
        synchronized (this) {
            counter++;
        }
        System.out.println("set et");
        String myStr1 = "osman";
        String myStr2 = "yaycıoğlu";
        operation3(myStr1,myStr2);
        System.out.println(myStr1);
    }

    public void operation3(String str1,String str2) {
        str1 = "deneme";
        atomicCounter.incrementAndGet();
    }

    public void increase(){
        try {
            readWriteLock.writeLock().lock();
            data++;
        } catch (Exception exp) {
            exp.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public long getData() {
        try {
            readWriteLock.readLock().lock();
            return data;
        } catch (Exception exp) {
            exp.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }

        return data;
    }
}

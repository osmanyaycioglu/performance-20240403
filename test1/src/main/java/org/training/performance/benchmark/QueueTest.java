package org.training.performance.benchmark;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.*;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> stringsLoc = new ArrayBlockingQueue<>(1_000);
        String        pollLoc    = stringsLoc.poll();

        BlockingQueue<String> blockingQueueLoc = new ArrayBlockingQueue<>(1_000);
        blockingQueueLoc.add("osman1");
        try {
            String takeLoc = blockingQueueLoc.take();
            System.out.println(takeLoc);
            String pollLoc1 = blockingQueueLoc.poll(1_000,
                                                    TimeUnit.MILLISECONDS);
            System.out.println(pollLoc1);
        } catch (InterruptedException eParam) {
            throw new RuntimeException(eParam);
        }
        Deque<String> dequeLoc = new ArrayDeque<>();
        BlockingDeque<String> blockingDequeLoc = new LinkedBlockingDeque<>();




    }
}

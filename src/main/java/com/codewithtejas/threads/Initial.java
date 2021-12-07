package com.codewithtejas.threads;

import java.util.ArrayList;
import java.util.List;

public class Initial {
    public static void main(String[] args) {

        // active thread count
        // 2 --> one for main method | one for garbage collector (background)
        // System.out.println(Thread.activeCount());

        // available cores on the machine CPU
        // 8 --> 4 cores with 2 threads each
        // System.out.println(Runtime.getRuntime().availableProcessors());

        // thread executing the main method
        // System.out.println("Current thread: " + Thread.currentThread().getName());

        /*for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new DownloadFileTask());
            thread.start();
        }*/

        // Thread thread = new Thread(new DownloadFileTask());
        // thread.start();

        /*// blocks this thread until the download thread has finished
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("File is ready!");*/

        // interrupt thread example
        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();*/

        // Race condition
        // var status = new DownloadStatus();
        List<Thread> threads = new ArrayList<>();
        List<DownloadFileTask> tasks = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            var task = new DownloadFileTask();
            tasks.add(task);
            var thread = new Thread(task);
            thread.start();
            threads.add(thread);
        }

        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        var totalBytes = tasks.stream()
                .map(t -> t.getStatus().getTotalBytes())
                .reduce(Integer::sum);

        System.out.println(totalBytes);

        // solution to race conditions
        // 1. confinement --> each thread gets its own resource to modify
        // 2. synchronization --> co-ordinate multiple threads accessing a resource
        //                    --> don't synchronize the whole method | sychronized(this)
        //                    --> use synchronized(new Object){} | for individual block
        // 3. volatile keyword --> tells the compiler this field value may change
        //                         compiler to use main memory for value of this field
        // 4. Atomic Objects --> these take only one instruction/operation
        // 5. Concurrent collections

    }
}

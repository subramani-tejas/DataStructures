package com.codewithtejas.threads;

public class Initial {
    public static void main(String[] args) {

        // active thread count
        // 2 --> one for main method | one for garbage collector (background)
        System.out.println(Thread.activeCount());

        // available cores on the machine CPU
        // 8 --> 4 cores with 2 threads each
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}

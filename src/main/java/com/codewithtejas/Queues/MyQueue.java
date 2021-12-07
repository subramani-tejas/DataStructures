package com.codewithtejas.Queues;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class MyQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println(queue);
        MyQueue.reverse(queue);
        System.out.println(queue);
    }

    public static void reverse(Queue<Integer> queue) {
        // add, remove, isEmpty
        // 10 20 30
        // *
        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty())
            stack.add(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());
    }
}

package com.codewithtejas.Stacks;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.Arrays;
import java.util.Stack;

public class MyStack {
    private final int[] array = new int[5];
    private int index;

    // push
    public void push(int element) {
        if (index == array.length) throw new StackOverflowError();
        array[index++] = element;
    }

    // pop
    public int pop() {
        if (index == 0) throw new IllegalStateException();
        return array[--index];
    }

    // peek
    public int peek() {
        if (index == 0) throw new IllegalStateException();
        return array[index - 1];
    }

    // isEmpty
    public boolean isEmpty() {
        return index == 0;
    }

    // print the stack
    public void printStack() {
        System.out.println(Arrays.toString(array));
    }

    // reverse a string
    public String reverseString(String input) {
        Stack<Character> stack = new Stack<>();

        // O(n)
        for (var item : input.toCharArray())
            stack.push(item);

        // O(n)
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty())
            reversed.append(stack.pop());

        return reversed.toString();
    }

    // if a string is a palindrome
    public boolean isPalindrome(String str){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++)
            stack.push(str.charAt(i));

        for(int i=0; i<str.length(); i++)
            if (stack.pop() == str.charAt(i)) return true;

        return false;
    }

    public static void main(String[] args) {
        MyStack ex = new MyStack();
        ex.push(10);
        ex.push(20);
        ex.push(30);
        ex.push(40);
        ex.push(50);
        // ex.printStack();
        // System.out.println(ex.peek());

        String str = "abb";
        System.out.println(ex.isPalindrome(str));
    }
}

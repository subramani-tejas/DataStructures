package com.codewithtejas.Arrays;

import java.util.Arrays;

// dynamic array implementation
public class Array {
    private int[] array;
    private int index;

    public Array(int length) {
        array = new int[length];
    }

    // insert number O(n)
    public void insert(int num) {
        // array full
        if (index == array.length) {
            int[] newArray = new int[index * 2];

            for (int i = 0; i < index; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[index++] = num;
    }

    // remove at index
    public void removeAt(int i) {
        if (i < 0 || i >= index) {
            System.out.println("Invalid index!");
            throw new IndexOutOfBoundsException();
        }

        for (int j = i; j <= index; j++) {
            array[j] = array[j + 1];
        }
        index--;
    }

    // index of number
    public int indexOf(int num) {
        for (int i = 0; i < index; i++) {
            if (array[i] == num)
                return i;
        }
        return -1;
    }

    // print array
    public void print() {
        int[] printArray = new int[index];
        for (int i = 0; i < index; i++) {
            printArray[i] = array[i];
        }
        System.out.println(Arrays.toString(printArray));
    }
    
    // max in array
    public int max() {
        int max = array[0];
        for (var item : array)
            if(item > max)
                max = item;

        return max;
    }

    // main
    public static void main(String[] args) {
        var numbers = new Array(3);
        numbers.insert(2); // 0
        numbers.insert(54);// 1
        numbers.insert(12);// 2
        numbers.insert(33);// 3
        // numbers.removeAt(0);
        System.out.println(numbers.indexOf(33));
        numbers.print();
    }
}

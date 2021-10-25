package com.codewithtejas.LinkedLists;

import com.codewithtejas.Arrays.Array;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class LinkedList {

    // implementation detail
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    // is list empty
    private boolean isEmpty() {
        return first == null;
    }

    // add at the beginning
    public void addFirst(int num) {

        var node = new Node(num);

        // if empty list
        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    // add at end of list
    public void addLast(int num) {
        var node = new Node(num);

        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    // delete first node
    public void deleteFirst() {

        // empty list
        if (isEmpty())
            throw new NoSuchElementException();

        // if only one element
        if (first == last)
            first = last = null;
        else {
            var second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    //delete last node
    public void deleteLast() {

        // if empty list
        if (isEmpty())
            throw new NoSuchElementException();

        // if only one element
        if (first == last)
            first = last = null;
        else {
            last = getPrevious(last);
            last.next = null;
        }
        size--;
    }

    // get previous node
    private Node getPrevious(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    // contains element?
    public boolean contains(int num) {
        return indexOf(num) != -1;
    }

    // index of element
    public int indexOf(int num) {
        int index = 0;
        var current = first;

        while (current != null) {
            if (current.value == num) return index;

            current = current.next;
            index++;
        }
        return -1;
    }

    // size of linked list
    public int size() {
        return size;
    }

    // convert linked list to array
    public int[] toArray() {
        int[] array = new int[size];
        var current = first;
        int index = 0;

        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    // reverse the linked list (in progress)
    public void reverse() {
        last.next = first;

        var temp = last;
        last = first;
        first = temp;
        last.next = null;

    }

    // main
    public static void main(String[] args) {
        var list = new LinkedList();
        list.addFirst(5);
        list.addFirst(52);
        list.addLast(32);
        list.addLast(19);
//        list.deleteFirst();
//        list.deleteLast();
//        System.out.println(list.indexOf(19));
//        System.out.println(list.contains(193));
        list.reverse();
        System.out.println(Arrays.toString(list.toArray()));
    }


}
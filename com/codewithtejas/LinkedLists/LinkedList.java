package com.codewithtejas.LinkedLists;

import com.codewithtejas.Arrays.Array;

import java.util.Arrays;
import java.util.List;
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

    // reverse the linked list
    public void reverse() {
        if (isEmpty()) return;

        Node previous = null;
        var current = first;
        var next = current.next;
        while (current != null) {
            current.next = previous;
            previous = current;
            current = next;

            if (current != null)
                next = current.next;
        }

        last = first;
        first = previous;
    }

    // get Kth node from the end (in progress)
    public Node getKthFromEnd(int k) {
        var x = first;
        var y = first;
        int difference = 0;

        while (y != null) {

            if (difference != (k - 1)) {
                y = y.next;
                difference++;
            }

            x = x.next;
            y = y.next;
        }
        return x;
    }

    // get middle node(s)
    public List<Integer> getMiddle() {

        var x = first;
        var y = first;
        while (y != last && y.next != last) {
            x = x.next;
            y = y.next.next;
        }

        if (y == last) return List.of(x.value);
        else return List.of(x.value, x.next.value);
        /*
         *  1   2   3   4   5   6   7   8   9
         *  X   X   X   X   X   X   X   X   X
         *                  x               y
         *
         * even #Nodes
         * y.next.next == null
         * return x & x.next   --> 4,5
         *
         *  1   3   5   7   9 --> #nodes +2
         *  1   2   3   4   5 --> middle 1
         * */

    }

    // has a loop?
    public boolean hasLoop() {
        var slow = first;
        var fast = first;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    // main
    public static void main(String[] args) {
        var list = new LinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.last = list.first;

        System.out.println(list.hasLoop());
    }
}
package com.codewithtejas.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        SetDemo.show();
    }

    public static void show() {
        Set<Character> set1 = new HashSet<>(Arrays.asList('a', 'b', 'c'));
        Set<Character> set2 = new HashSet<>(Arrays.asList('b', 'c', 'd'));

        // union
        set1.addAll(set2);
        System.out.println(set1);

        // intersection
        set1.retainAll(set2);
        System.out.println(set1);

        // difference --> what we have in set1 not in set2
        set1.removeAll(set2);
        System.out.println(set1);
    }
}

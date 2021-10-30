package com.codewithtejas.HashTables;

import com.sun.source.tree.BreakTree;

import java.io.CharArrayReader;
import java.util.*;

public class HashMaps {

    // find most repeated character in a string
    public char mostRepeatedCharacter(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toLowerCase().toCharArray();

        // map to count occurrences | O(n)
        for (var item : chars) {
            /*if (map.containsKey(item)) {
                var count = map.get(item);
                map.put(item, ++count);
            } else map.put(item, 1);*/
            var count = map.containsKey(item) ? map.get(item) : 0;
            map.put(item, count + 1);
        }

        List<Integer> list = new ArrayList<>();
        // O(n)
        for (var item : map.keySet())
            list.add(map.get(item));

        var max = list.get(0);
        // O(n)
        for (var item : list)
            if (max < item)
                max = item;

        // O(n)
        for (var item : chars)
            if (map.get(item).equals(max))
                return item;

        return Character.MIN_VALUE;
    }

    // first repeated character
    public char firstRepeatedCharacter(String str) {
        char[] chars = str.toLowerCase().toCharArray();
        Set<Character> set = new HashSet<>();

        for (var item : chars) {
            if (set.contains(item))
                return item;
            set.add(item);
        }
        return Character.MIN_VALUE;
    }

    // count pairs with difference K
    /*
     * Given an array of integers, count the number of unique pairs of integers
     * that have difference k.
     * Input: [1, 7, 5, 9, 2, 12, 3] K=2
     * Output: 4
     * We have four pairs with difference 2:
     * (1, 3), (3, 5), (5, 7), (7, 9).
     * Note that we only want the number of these pairs, not the pairs themselves.
     *
     * */
    public int countPairsWithDiff(int[] arr, int k) {

        // w/o data structures
        /*int count = 0;
        // O(n^2)
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < i; j++)
                if (Math.abs(arr[i] - arr[j]) == k)
                    count++;

        return count;*/

        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (var item : arr)
            set.add(item);

        for (var item : arr) {
            if (set.contains(item + k)) count++;
            if (set.contains(item - k)) count++;
            set.remove(item);
        }
        return count;
    }

    // return indices of two numbers that add up to target
    /*
     * Given an array of integers, return indices of the two numbers
     * such that they add up to a specific target.
     * Input: [2, 7, 11, 15] | target = 9
     * Output: [0, 1] (because 2 + 7 = 9)
     * Assume that each input has exactly one solution, and you may not use the same element twice.
     *
     * */
    public int[] twoSum(int[] arr, int target) {

        // w/o data structures
        /*for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < i; j++)
                if (arr[i] + arr[j] == target)
                    System.out.println("here: " + j + ", " + i);*/

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int temp = target - arr[i];
            if (map.containsKey(temp))
                return new int[]{map.get(temp), i};

            map.put(arr[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        String str = "a green apple";
        HashMaps map = new HashMaps();
        /*System.out.println(map.mostRepeatedCharacter(str));
        System.out.println(map.firstRepeatedCharacter(str));*/

        int[] arr = {8, 1, 2, 7, 11, 15};
        /*System.out.println(map.countPairsWithDiff(arr, 2));
        System.out.println(Arrays.toString(map.twoSum(arr, 9)));*/
    }
}

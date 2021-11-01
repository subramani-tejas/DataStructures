package com.codewithtejas.LinkedLists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KnapsackProblem {

    public static void solve(int[] profits, int[] weights, int capacity) {
        List<Integer> profitPerUnit = new ArrayList<>();

        for (int i = 0; i < profits.length; i++)
           profitPerUnit.add(profits[i] / weights[i]);

        // profitPerUnit = [6, 5, 4, 3, 3, 1, 1]
        Collections.sort(profitPerUnit);
        Collections.reverse(profitPerUnit);


    }

    public static void main(String[] args) {
        int[] profits = {10, 5, 15, 7, 6, 18, 3};
        int[] weights = {2, 3, 5, 7, 1, 4, 1};
        int capacity = 15;
        KnapsackProblem.solve(profits, weights, capacity);
    }
}

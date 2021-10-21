package com.codewithtejas.HR;
//Complete this code or write your own from scratch

import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] argh) {
        Map<String, Integer> phonebook = new HashMap<String, Integer>();
        Scanner in = new Scanner(System.in);

        // number of entries
        int n = in.nextInt();

        // entries
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            phonebook.put(name, phone);
            in.nextLine();
        }

        // queries
        while (in.hasNext()) {
            String s = in.nextLine();
            if (phonebook.get(s) != null)
                System.out.println(s + "=" + phonebook.get(s));
            else System.out.println("Not found");
        }
        in.close();
    }
}




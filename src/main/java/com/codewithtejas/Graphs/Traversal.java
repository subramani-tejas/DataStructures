package com.codewithtejas.Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Traversal {
    public static List<Node> goDepthFirst(List<Node> nodes) {
        List<Node> result = new ArrayList<>();
        Set<Node> visited = new HashSet<>();




        return result;
    }

    public static class Node {
        String label;
        List<Node> children = new ArrayList<>();

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "label='" + label + '\'' +
                    ", children=" + children +
                    '}';
        }
    }
}

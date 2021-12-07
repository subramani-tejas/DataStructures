package com.codewithtejas.Graphs;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TraversalTest {

    @Test
    public void TestCase1() {
        Traversal.Node A = new Traversal.Node("A");
        Traversal.Node B = new Traversal.Node("B");
        Traversal.Node C = new Traversal.Node("C");
        Traversal.Node D = new Traversal.Node("D");

        A.children.add(B);
        A.children.add(C);

        B.children.add(D);

        D.children.add(C);

        List<Traversal.Node> nodes = new ArrayList<>();
        nodes.add(A);
        nodes.add(B);
        nodes.add(C);
        nodes.add(D);

        List<Traversal.Node> expected = Arrays.asList(A, B, D, C);
        List<Traversal.Node> actual = Traversal.goDepthFirst(nodes);
        Assert.assertEquals(expected, actual);
    }
}

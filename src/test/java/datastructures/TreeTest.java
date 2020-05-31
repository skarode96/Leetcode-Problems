package datastructures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TreeTest {

    private Tree tree;

    @Before
    public void createTree() {
        Tree tree = new Tree(0);
        tree.root.left = new Node(1);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(6);
        this.tree = tree;
    }

    @Test
    public void shouldCreateTree() {
        Assert.assertEquals(0, tree.root.value);
        Assert.assertEquals(1, tree.root.left.value);
        Assert.assertEquals(2, tree.root.right.value);
        Assert.assertEquals(3, tree.root.left.left.value);
        Assert.assertEquals(4, tree.root.left.right.value);
        Assert.assertEquals(5, tree.root.right.left.value);
        Assert.assertEquals(6, tree.root.right.right.value);
    }

    @Test
    public void shouldTraverseInorder() {
        tree.inOrderTraversal(tree.root);
    }

    @Test
    public void shouldTraversePreOrder() {
        tree.preOrderTraversal(tree.root);
    }

    @Test
    public void shouldTraversePostOrder() {
        tree.postOrderTraversal(tree.root);
    }

    @Test
    public void shouldTraverseInorderWithoutRecursion() {
        tree.inOrderTraversalWithoutRecursion(tree.root);
    }

    @Test
    public void shouldFindHeightWithRecursion() {
        tree = new Tree(0);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        int actualHeight = tree.findHeight(tree.root);
        Assert.assertEquals(3, actualHeight);
    }

    @Test
    public void shouldFindNumberOfNodesInTree() {
        int n = tree.findNumberOfNodes(tree.root);
        Assert.assertEquals(7, n);
    }

    @Test
    public void shouldPrintLevelOrderTree() {
        tree.levelOrderTraversal();
    }
}
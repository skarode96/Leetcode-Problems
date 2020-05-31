package datastructures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {
    public Node root;

    public Tree(int value) {
        this.root = new Node(value);
    }

    public void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(" " + node.value + " ");
            inOrderTraversal(node.right);
        }
    }

    public void preOrderTraversal(Node node) {
        if(node != null) {
            System.out.print(" " + node.value + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    public void postOrderTraversal(Node node) {
        if(node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(" " + node.value + " ");
        }
    }

    public void inOrderTraversalWithoutRecursion(Node root) {
        Stack<Node> nodeStack = new Stack<>();
        Node node = root;
        while (node != null || nodeStack.size() > 0) {

            //Traverse Left node and push it to stack
            while (node != null) {
                nodeStack.push(node);
                node = node.left;
            }

            // bring each node
            node = nodeStack.pop();
            System.out.println( " " + node.value + " ");

            // traverse right portion
            node = node.right;
        }

    }

    public int findHeight(Node root) {
        if (root != null)  {
            int maxOfLeftSubTree = findHeight(root.left);
            int maxOfRightSubTree = findHeight(root.right);
            return Math.max(maxOfLeftSubTree, maxOfRightSubTree) + 1;
        }
        return 0;
    }

    public int findNumberOfNodes(Node node) {

        if(node != null) {
            return findNumberOfNodes(node.left) + 1 + findNumberOfNodes(node.right);
        }
        return 0;
    }

    public void levelOrderTraversal() {
        Queue<Node> nodeQueue = new LinkedList<>();

        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()){

            Node topNode = nodeQueue.poll();
            System.out.println(topNode.value);

            if(topNode.left!= null){
                nodeQueue.add(topNode.left);
            }
            if (topNode.right!=null){
                nodeQueue.add(topNode.right);
            }
        }

    }

}


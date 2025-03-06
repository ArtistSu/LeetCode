package algorithm.tree;

import algorithm.common.TreeNode;

import java.util.Stack;

public class PostOrder {
    public static void postOrder(TreeNode node) {
        if (node == null) return;
        postOrder(node.left); // print left node
        postOrder(node.right); // print right node
        System.out.print(node.val + " "); // print root node
    }

    public static void postOrderUnRecur(TreeNode node) {
        if (node == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisited = null;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                if (stack.peek().right != null && stack.peek().right != lastVisited) {
                    node = stack.peek().right;
                } else {
                    lastVisited = stack.pop();
                    System.out.print(lastVisited.val + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println("Recur");
        postOrder(root);
        System.out.println("");
        System.out.println("UnRecur");
        postOrderUnRecur(root);
    }
}

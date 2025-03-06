package algorithm.tree;

import algorithm.common.TreeNode;

import java.util.Stack;

public class Inorder {
    public static void inOrder(TreeNode node){
        if(node == null) return ;
        inOrder(node.left); // print left node
        System.out.print(node.val + " "); // print root node
        inOrder(node.right); // print right node
    }

    public static void inOrderUnRecur(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.val + " ");
                    head = head.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println("Recur");
        inOrder(root);
        System.out.println("");
        System.out.println("UnRecur");
        inOrderUnRecur(root);
    }
}

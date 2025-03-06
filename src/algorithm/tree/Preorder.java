package algorithm.tree;

import algorithm.common.TreeNode;

import java.util.Stack;

public class Preorder {
    public static void preOrder(TreeNode node){
        if(node == null) return ;
        System.out.print(node.val + " "); // print root node first
        preOrder(node.left); // print left node
        preOrder(node.right); // print right node
    }

    public static void preOrderUnRecur(TreeNode node){
        if(node != null){
            Stack<TreeNode> stack = new Stack<>();
            stack.push(node);
            while(!stack.isEmpty()){
                node = stack.pop();
                System.out.print(node.val + " ");

                if(node.right != null) stack.push(node.right);
                if(node.left != null) stack.push(node.left);;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println("Recur");
        preOrder(root);
        System.out.println("");
        System.out.println("UnRecur");
        preOrderUnRecur(root);
    }
}

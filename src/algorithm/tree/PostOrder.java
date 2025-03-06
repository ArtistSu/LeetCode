package algorithm.tree;

import algorithm.common.TreeNode;

public class PostOrder {
    public void postOrder(TreeNode node) {
        if (node == null) return;
        postOrder(node.left); // print left node
        System.out.println(node); // print root node
        postOrder(node.right); // print right node
    }
}

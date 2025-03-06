package algorithm.tree;

import algorithm.common.TreeNode;

public class Preorder {
    public void preOrder(TreeNode node){
        if(node == null) return ;
        System.out.println(node); // print root node first

        preOrder(node.left); // print left node
        preOrder(node.right); // print right node
    }
}

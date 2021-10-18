package JavaCode;

import sun.text.UCompactIntArray;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Java101 {
    public class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {

            this.val = val;

            this.left = left;

            this.right = right;

        }

    }

    // Top - down Time Complexity : O(1) Space Complexity: O(1)
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null || t1.val != t2.val) {
            return false;
        }

        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    public static void main(String[] args) {
        Java101.TreeNode a7 = new Java101().new TreeNode(3, null, null);
        Java101.TreeNode a6 = new Java101().new TreeNode(4, null, null);
        Java101.TreeNode a5 = new Java101().new TreeNode(4, null, null);
        Java101.TreeNode a4 = new Java101().new TreeNode(3, null, null);
        Java101.TreeNode a3 = new Java101().new TreeNode(2, a6, a7);
        Java101.TreeNode a2 = new Java101().new TreeNode(2, a4, a5);
        Java101.TreeNode a1 = new Java101().new TreeNode(1, a2, a3);
        System.out.println(new Java101().isSymmetric(a1));

    }
}


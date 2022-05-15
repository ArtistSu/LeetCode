package JavaCode;

import sun.text.UCompactIntArray;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Java101 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @topic Symmetric Tree
     * @author ArtistS
     * @param root
     * @return
     */

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode leftNode, TreeNode rightNode){
        if(leftNode == null && rightNode == null){
            return true;
        }
        if(leftNode == null || rightNode == null){
            return false;
        }
        if(leftNode.val != rightNode.val){
            return false;
        }
        return isSymmetric(leftNode.left, rightNode.right) && isSymmetric(leftNode.right, rightNode.left);
    }
}



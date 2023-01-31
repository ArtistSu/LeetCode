package JavaCode;

import java.util.Deque;
import java.util.LinkedList;

public class Java98 {
    /**
     * Time Complexity: O(n) {@param n} is the number of nodes in {@param root}
     * Space Complexity: O(n)
     * @topic Validate Binary Search Tree
     * @author ArtistS
     * @methor Recursion
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long lower, long upper){
        if(root == null){
            return true;
        }
        if(root.val <= lower || root.val >= upper){
            return false;
        }
        return isValidBST(root.left,lower, root.val) & isValidBST(root.right,root.val,upper);
    }
}

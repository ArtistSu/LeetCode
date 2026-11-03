package JavaCook;

import java.util.*;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_530 {
    /**
     * @TimeComplexity O(N) N is the number of nodes in the tree
     * @SpaceComplexity O(H) H is the height of the tree
     */
    private TreeNode prev = null;
    private int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference_google_l4(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null) {
            minDiff = Math.min(minDiff, root.val - prev.val);
        }
        prev = root;
        inorder(root.right);
    }
}
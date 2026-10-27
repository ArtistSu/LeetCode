package JavaCook;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ArtistS
 * @tag Recursion
 * @prb https://leetcode.com/problems/symmetric-tree/description/ Time complexity: O(n) Space complexity: O(n)
 */
public class Java_101 {
    /**
     * Time complexity: O(N) N is the number of nodes in Tree root
     * Space complexity: O(H) H is the height of Tree root
     */
    public boolean isSymmetric_google_l4(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;

        if (root1 == null || root2 == null) return false;

        return root1.val == root2.val && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
    }

    /**
     * Time complexity: O(N) N is the number of nodes in Tree root
     * Space complexity: O(H) H is the height of Tree root
     *
     * Note: ArrayDeque does not permit null elements, so we must perform null checks before pushing. We avoid
     * LinkedList to prevent unnecessary Node object allocation overhead and leverage the better cache locality of
     * ArrayDeque.
     */
    public boolean isSymmetric_google_l4_2(TreeNode root) {
        if (root == null) return true;

        Deque<TreeNode> stack = new ArrayDeque<>();
        // Determine it is null or not
        if (root.left != null) stack.push(root.left);
        if (root.right != null) stack.push(root.right);

        if (stack.size() == 1) return false;

        while (!stack.isEmpty()) {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();

            if (left.val != right.val) return false;

            if (left.left != null && right.right != null) {
                stack.push(left.left);
                stack.push(right.right);
            } else if (left.left != null || right.right != null) {
                return false;
            }

            if (left.right != null && right.left != null) {
                stack.push(left.right);
                stack.push(right.left);
            } else if (left.right != null || right.left != null) {
                return false;
            }
        }

        return true;
    }
}
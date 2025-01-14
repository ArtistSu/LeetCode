package JavaCook;

import java.util.Stack;

/**
 * @author ArtistS
 * @tag Iteration Stack
 * @prb https://leetcode.com/problems/symmetric-tree/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_101_2 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        TreeNode left, right;
        while (!stack.isEmpty()) {
            right = stack.pop();
            left = stack.pop();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            stack.push(right.left);
            stack.push(left.right);
            stack.push(right.right);
            stack.push(left.left);
        }
        return true;
    }
}

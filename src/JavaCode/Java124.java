package JavaCode;

import JavaCook.TreeNode;

public class Java124 {
    int maxSum = Integer.MIN_VALUE;

    /**
     * Time Complexity: O(n) {@param n} is the number of nodes in {@params root}
     * Space Complexity: O(n)
     * @topic Binary Tree Maximum Path Sum
     * @author ArtistS
     * @method recursion
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        int priceNewpath = node.val + leftGain + rightGain;

        maxSum = Math.max(maxSum, priceNewpath);

        return node.val + Math.max(leftGain, rightGain);
    }

}

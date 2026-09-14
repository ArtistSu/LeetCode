package JavaCook;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_1372 {
    /**
     * Time complexity is O(n^2), but it will report over time limit due to the number of operation over 10^8.
     */
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;

        Deque<TreeNode> queue = new LinkedList<>();
        int res = 0;

        while (!queue.isEmpty()) {
            TreeNode currNode = queue.pollFirst();
            res = Math.max(res, Math.max(dfs(currNode, true), dfs(currNode, false)));
            if (currNode.left != null) queue.offer(currNode.left);
            if (currNode.right != null) queue.offer(currNode.right);
        }

        return res;
    }

    // true -> left, false -> right
    public int dfs(TreeNode currNode, boolean direction) {
        if (currNode == null) return 0;
        int count = 0;
        if (direction) {
            if (currNode.left != null) {
                count = dfs(currNode, false) + 1;
            }
        } else {
            if (currNode.right != null) {
                count = dfs(currNode, true) + 1;
            }
        }
        return count;
    }

    /**
     * Google L4, you need to optimize the time complexity to O(n)
     */
    int longestPath = 0;

    public int longestZigZag_google_l4(TreeNode root) {
        if (root == null) return 0;
        dfs(root, true, 0);
        return longestPath;
    }

    public void dfs(TreeNode node, boolean goLeft, int steps) {
        if (node == null) return;

        longestPath = Math.max(longestPath, steps);

        if (goLeft) {
            dfs(node.left, false, steps + 1);
            dfs(node.right, true, 1);
        } else {
            dfs(node.left, false, 1);
            dfs(node.right, true, steps + 1);
        }
    }

    /**
     * But the version of L4 still has one potential issue, it will pollute the global variable.
     */
    public int longestZigZag_google_l4_improvement(TreeNode root) {
        if (root == null) return 0;
        int[] pathLength = new int[1];
        dfs_google_l4(root, true, 0, pathLength);
        return pathLength[0];
    }

    public void dfs_google_l4(TreeNode node, boolean goLeft, int steps, int[] pathLength) {
        if (node == null) return;

        pathLength[0] = Math.max(pathLength[0], steps);

        if (goLeft) {
            dfs_google_l4(node.left, false, steps + 1, pathLength);
            dfs_google_l4(node.right, true, 1, pathLength);
        } else {
            dfs_google_l4(node.left, false, 1, pathLength);
            dfs_google_l4(node.right, true, steps + 1, pathLength);
        }
    }

    /**
     * Google L5 prefer API design, and readability.
     */

    private enum Direction {
        LEFT, RIGHT
    }
    public int longestZigZag_google_l5(TreeNode root) {
        if (root == null) return 0;
        int[] maxZigZagLength = new int[1];
        dfs(root, Direction.LEFT, 0, maxZigZagLength);
        return maxZigZagLength[0];
    }

    public void dfs_google_l5(TreeNode node, Direction direction, int steps, int[] maxZigZagLength) {
        if (node == null) return;

        maxZigZagLength[0] = Math.max(maxZigZagLength[0], steps);

        if (direction == Direction.LEFT) {
            dfs(node.left, Direction.RIGHT, steps + 1, maxZigZagLength);
            dfs(node.right, Direction.LEFT, 1, maxZigZagLength);
        } else {
            dfs(node.left, Direction.RIGHT, 1, maxZigZagLength);
            dfs(node.right, Direction.LEFT, steps + 1, maxZigZagLength);
        }
    }

}
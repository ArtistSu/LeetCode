package JavaCook;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_129 {
    /**
     * @TimeComplexity O(N) N is the number of nodes in the tree
     * @SpaceComplexity O(M) M is the number of distinct paths from root to leaves
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;

        List<Integer> res = new ArrayList<>();
        // 1. Find all root->leaf path
        findPaths(root, 0, res);

        // 2. Sum
        int sum = 0;
        for (int num : res) {
            sum += num;
        }
        return sum;
    }

    public void findPaths(TreeNode root, int currNum, List<Integer> res) {
        if(root == null) return;
        currNum = currNum * 10 + root.val;

        if (root.left == null && root.right == null) {
            res.add(currNum);
            return;
        }

        findPaths(root.left, currNum, res);
        findPaths(root.right, currNum, res);
    }

    /**
     * @TimeComplexity O(N) N is the number of nodes in the tree
     * @SpaceComplexity O(H) H is the height of the tree
     */
    public int sumNumbers_google_l4(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }

        currentSum = currentSum * 10 + node.val;

        if (node.left == null && node.right == null) {
            return currentSum;
        }

        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }
}
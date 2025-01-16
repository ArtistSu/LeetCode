package JavaCook;

/**
 * @author ArtistS
 * @tag DFS
 * @prb https://leetcode.com/problems/path-sum/description/
 * Time complexity: O(n) n is the number of nodes
 * Space complexity: O(h) h is the height of teh tree
 */
public class Java_112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
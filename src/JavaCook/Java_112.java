package JavaCook;

/**
 * @author ArtistS
 * @tag DFS
 * @prb https://leetcode.com/problems/path-sum/description/
 * Time complexity: O(n) n is the number of nodes
 * Space complexity: O(h) h is the height of teh tree
 */
public class Java_112 {
    /**
     * Time complexity: O(N) N is the number of nodes in Tree root
     * Space complexity: O(H) H is the height of the Tree root
     */
    public boolean hasPathSum_google_l4(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum_google_l4(root.left, targetSum - root.val) || hasPathSum_google_l4(root.right, targetSum - root.val);
    }
}
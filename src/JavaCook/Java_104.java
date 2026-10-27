package JavaCook;

/**
 * @author ArtistS
 * @tag Recursion DFS
 * @prb https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_104{
    /**
     * Time complexity: O(N) N is the number of nodes under TreeNode root
     * Space complexity: O(N)
     */
    public int maxDepth_google_l4(TreeNode root) {
        if(root == null) return 0;

        return Math.max(maxDepth_google_l4(root.left),maxDepth_google_l4(root.right)) + 1;
    }
}
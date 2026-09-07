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
     * You can mention there is a StackOverflowError risk here, If the tree is very deep.
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
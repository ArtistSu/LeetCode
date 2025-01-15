package JavaCook;

/**
 * @author ArtistS
 * @tag Recursion DFS
 * @prb https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_111{
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null){
            return 1 + minDepth(root.right);
        }
        if(root.right == null){
            return 1 + minDepth(root.left);
        }
        return 1+Math.min(minDepth(root.left),minDepth(root.right));
    }
}
package JavaCook;

/**
 * @author ArtistS
 * @tag DFS Recursion
 * @prb https://leetcode.com/problems/balanced-binary-tree/description/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_110{
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return (Math.abs(bbtHelper(root.left) - bbtHelper(root.right)) > 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    public int bbtHelper(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1+ Math.max(bbtHelper(root.left),bbtHelper(root.right));
    }
}
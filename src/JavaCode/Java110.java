package JavaCode;

import JavaCook.TreeNode;

public class Java110 {
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     * @method Recursion || UpBottom
     * @topic Balanced Binary Tree
     * @author ArtistS
     * @param root
     * @return
     */
    public boolean isBalanced2(TreeNode root) {
        if(root == null){
            return true;
        }
        return Math.abs(upBottom(root.left) - upBottom(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int upBottom(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(upBottom(root.left), upBottom(root.right)) + 1;
    }
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @method Recursion || BottomUp
     * @topic Balanced Binary Tree
     * @author ArtistS
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return bottomUp(root) != -1;
    }

    public int bottomUp(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = bottomUp(root.left);
        int right = bottomUp(root.right);

        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}

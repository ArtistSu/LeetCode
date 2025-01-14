package JavaCode;

import JavaCook.TreeNode;

public class Java104 {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @topic Maximum Depth of Binary Tree
     * @author ArtistS
     * @method recursion
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return Math.max(left, right);
    }
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @method recursion
     * @topic Maximum Depth of Binary Tree
     * @author ArtistS
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}

package JavaCode;

public class Java104 {
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

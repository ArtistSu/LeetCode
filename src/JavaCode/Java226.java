package JavaCode;

public class Java226 {
    /**
     * Time Complexity: O(n) {@code n} is the number of nodes
     * Space Complexity: O(n)
     * @topic Invert Binary Tree
     * @author ArtistS
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
